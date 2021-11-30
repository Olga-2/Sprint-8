package src.test.kotlin.ru.sberschool.hystrix

import feign.httpclient.ApacheHttpClient
import feign.hystrix.HystrixFeign
import feign.jackson.JacksonDecoder
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import feign.Request

import ru.sberschool.hystrix.PokeStatFallbackApi
import ru.sberschool.hystrix.Stat

import src.main.kotlin.ru.sberschool.hystrix.PokeApi
import java.util.concurrent.TimeUnit

class PokeApiTest {

    private fun  getClient(t1: TimeUnit): PokeApi
    {
        return  HystrixFeign.builder()
            .client(ApacheHttpClient())
            .decoder(JacksonDecoder())
            .options(Request.Options(1, t1, 1, t1, true))
            .target(PokeApi::class.java, "https://pokeapi.co/api/v2", PokeStatFallbackApi())
    }

    @Test
    fun `getStatByName() should return predefined data`() {

        val stat: Stat = getClient(TimeUnit.SECONDS).getStat("attack")
        // expect
        assertEquals("attack", stat.name)
        assertEquals(2, stat.id)
    }

    @Test
    fun `getStatByName() shouldn't return predefined data`() {

        val stat: Stat = getClient(TimeUnit.MINUTES).getStat("speed")

        // expect
        assertEquals("evasion", stat.name)
        assertEquals(8, stat.id)

    }
}