/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package rubiks

import kotlin.test.Test
import kotlin.test.assertNotNull
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class AppTest {

    @Test fun cubeRotationsAreInvariant() {
        val cube = Cube()
        val identityRotations = arrayOf("FFFF", "UUUU", "LLLL", "FFFF", "BBBB", "DDDD", "RRRR")
        for(rot in identityRotations) {
            for (c in rot.toCharArray()) {
                cube.rotate(c)
            }
            assertTrue(cube.isIdentical(Cube()))
        }
    }
}