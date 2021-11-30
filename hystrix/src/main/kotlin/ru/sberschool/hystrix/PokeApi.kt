package src.main.kotlin.ru.sberschool.hystrix

import feign.Param
import feign.RequestLine
import ru.sberschool.hystrix.Stat

interface PokeApi {

    @RequestLine("GET /stat/{name}")
    fun getStat(@Param("name") nameStat: String): Stat

}
