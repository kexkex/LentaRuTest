package ru.tomindapps.lentarutest

import org.junit.Test

import org.junit.Assert.*
import ru.tomindapps.lentarutest.models.NewsLoader

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        var s = NewsLoader.parseJson()[0].info.id
        print(s)
    }
}
