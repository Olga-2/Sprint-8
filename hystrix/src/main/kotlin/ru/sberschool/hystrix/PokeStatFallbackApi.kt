package ru.sberschool.hystrix

import src.main.kotlin.ru.sberschool.hystrix.PokeApi

class PokeStatFallbackApi : PokeApi {

    // уклонение по-умолчанию уклонение
    override fun getStat(nameStat: String): Stat {

        return Stat(8, "evasion", 0, true,
            MoveStatAffectSets(listOf(MoveStatAffect(-2, NamedApiResource("sweet-scent","https://pokeapi.co/api/v2/move/230/"))),
                listOf(MoveStatAffect(1, NamedApiResource("double-team","https://pokeapi.co/api/v2/move/104/")))),
            NatureStatAffectSets(listOf(NamedApiResource("","")), listOf( NamedApiResource("",""))),
            listOf(ApiResource("")), null,
            listOf(Name("evasion", NamedApiResource("en", "https://pokeapi.co/api/v2/language/9/"))))
    }


}