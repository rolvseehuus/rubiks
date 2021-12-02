package rubiks

import kotlin.test.Test
import kotlin.test.assertNotNull
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import kotlin.test.assertFalse

class SearchTest {
    @Test fun testRecognizedSolvedCube(){


    }

    @Test fun testSearchACube(){

        val c = Cube()
        c.transform("rUR".toCharArray())
        val s = Search(c)
        s.search()
    }
}