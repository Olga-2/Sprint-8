package ru.sberschool.hystrix

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class Stat @JsonCreator constructor(
    // уникальный id умения
    @JsonProperty("id")
    val id: Int,
    // название,
    @JsonProperty("name")
    val name: String,
    // идентификатор, который используют в играх для этого умения
    @JsonProperty("game_index")
    val gameIndex: Int,
    //только для сражений?
    @JsonProperty("is_battle_only")
    val isBattleOnly: Boolean,
    // Информация об активностях, которые влияют на умение положительно или отрицательно
    @JsonProperty("affecting_moves")
    val affectingMoves: MoveStatAffectSets?,
    // Информация об особенностях природы, которые влияют на умение положительно или отрицательно
    @JsonProperty("affecting_natures")
    val affectingNatures: NatureStatAffectSets?,
    // характеристики покемона, если он достиг этого умения
    @JsonProperty("characteristics")
    val characteristics: List<ApiResource>?,
    // класс урона
    @JsonProperty("move_damage_class")
    val moveDamageClass: NamedApiResource?,
    //Список названия умения на разных языках
    @JsonProperty("names")
    val names: List<Name?>,


    )

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class Name @JsonCreator constructor(
    @JsonProperty("name")  val name: String,
    @JsonProperty("language")   val url: NamedApiResource,
)

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class MoveStatAffectSets @JsonCreator constructor(
    @JsonProperty("increase")    val increase: List<MoveStatAffect>,
    @JsonProperty("decrease")    val decrease: List<MoveStatAffect>,
)

data class MoveStatAffect @JsonCreator constructor(
    @JsonProperty("change") val change: Int,
    @JsonProperty("move")   val move: NamedApiResource
)
class NamedApiResource @JsonCreator constructor(
    @JsonProperty("name")  val name: String,
    @JsonProperty("url")   val url: String,
    )
class ApiResource @JsonCreator constructor(
    @JsonProperty("url")   val url: String,
)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class NatureStatAffectSets @JsonCreator constructor(
    @JsonProperty("increase")    val increase: List<NamedApiResource>,
    @JsonProperty("decrease")    val decrease: List<NamedApiResource>,
)
