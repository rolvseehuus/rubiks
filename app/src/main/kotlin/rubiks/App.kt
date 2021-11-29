package rubiks


class Cube () {
    private val cube = Array<CharArray>(6) { CharArray(9)}
    private val labels: CharArray = "UFBRLD".toCharArray()

    init {
        /*
        U: White
        F: Orange
        D: Yellow
        L: Blue
        R: Green
        B: Red
         */
        for (i in 0 until 6)
            for (j in 0 until 9)
                cube[i][j] = "WOYBGR".toCharArray()[i]
    }

    fun rotateF(){
        // rotate front:
        // Transition:
        val from = arrayOf(0,1,2,5,8,7,6,3,0,4)
        val to = arrayOf(2,5,8,7,6,3,0,1,2,4)
        val cp = CharArray(9)

        for(i in from.indices)
            cp[to[i]] = cube[1][from[i]]
        for(i in cp.indices)
            cube[1][i] = cp[i]

        // Move UFBRLD
        val cb = Cube()
        val c_r=arrayOf(0,3,6)
        val c_d=arrayOf(0,1,2)
        val c_l=arrayOf(2,5,8)
        val c_u=arrayOf(6,7,8)

        for(i in c_r.indices) {
            cb.cube[5][c_d[i]] = cube[3][c_r[i]]
            cb.cube[0][c_u[i]] = cube[4][c_l[i]]
            cb.cube[3][c_r[i]] = cube[0][c_u[i]]
            cb.cube[4][c_l[i]] = cube[5][c_d[i]]
        }

        // Copy back
        for(i in c_r.indices){
            cube[5][c_d[i]] = cb.cube[5][c_d[i]]
            cube[0][c_u[i]] = cb.cube[0][c_u[i]]
            cube[3][c_r[i]] = cb.cube[3][c_r[i]]
            cube[4][c_l[i]] = cb.cube[4][c_l[i]]
        }
     }

    fun rotateU(){
        // rotate top:
        // Transition:
        val from = arrayOf(0,1,2,5,8,7,6,3,0,4)
        val to = arrayOf(2,5,8,7,6,3,0,1,2,4)
        val cp = CharArray(9)

        for(i in from.indices)
            cp[to[i]] = cube[0][from[i]]
        for(i in cp.indices)
            cube[0][i] = cp[i]

        // Move UFBRLD
        val cb = Cube()
        val c_d=arrayOf(0,1,2)

        for(i in c_d.indices) {
            cb.cube[2][c_d[i]] = cube[4][c_d[i]]
            cb.cube[3][c_d[i]] = cube[2][c_d[i]]
            cb.cube[4][c_d[i]] = cube[1][c_d[i]]
            cb.cube[1][c_d[i]] = cube[3][c_d[i]]
        }

        // Copy back
        for(i in c_d.indices){
            cube[1][c_d[i]] = cb.cube[1][c_d[i]]
            cube[2][c_d[i]] = cb.cube[2][c_d[i]]
            cube[3][c_d[i]] = cb.cube[3][c_d[i]]
            cube[4][c_d[i]] = cb.cube[4][c_d[i]]
        }
    }

    fun rotateB(){
        // rotate back:
        // Transition:
        val from = arrayOf(0,1,2,5,8,7,6,3,0,4)
        val to = arrayOf(2,5,8,7,6,3,0,1,2,4)
        val cp = CharArray(9)

        for(i in from.indices)
            cp[to[i]] = cube[2][from[i]]
        for(i in cp.indices)
            cube[2][i] = cp[i]

        // Move UFBRLD
        val cb = Cube()
        val c_l=arrayOf(0,3,6)
        val c_u=arrayOf(0,1,2)
        val c_r=arrayOf(2,5,8)
        val c_d=arrayOf(6,7,8)

        for(i in c_r.indices) {
            cb.cube[0][c_u[i]] = cube[3][c_r[i]]
            cb.cube[5][c_d[i]] = cube[4][c_l[i]]
            cb.cube[4][c_l[i]] = cube[0][c_u[i]]
            cb.cube[3][c_r[i]] = cube[5][c_d[i]]
        }
        // Copy back
        for(i in c_d.indices){
            cube[0][c_u[i]] = cb.cube[0][c_u[i]]
            cube[5][c_d[i]] = cb.cube[5][c_d[i]]
            cube[4][c_l[i]] = cb.cube[4][c_l[i]]
            cube[3][c_r[i]] = cb.cube[3][c_r[i]]
        }
    }

    fun rotateR(){
        // rotate right:
        // Transition:
        val from = arrayOf(0,1,2,5,8,7,6,3,0,4)
        val to = arrayOf(2,5,8,7,6,3,0,1,2,4)
        val cp = CharArray(9)

        for(i in from.indices)
            cp[to[i]] = cube[3][from[i]]
        for(i in cp.indices)
            cube[3][i] = cp[i]

        // UFBRLD
        // 012345
        val cb = Cube()
        val c_d=arrayOf(6,7,8)

        for(i in c_d.indices) {
            cb.cube[2][c_d[i]] = cube[0][c_d[i]]
            cb.cube[5][c_d[i]] = cube[2][c_d[i]]
            cb.cube[1][c_d[i]] = cube[5][c_d[i]]
            cb.cube[0][c_d[i]] = cube[1][c_d[i]]
        }
        // Copy back
        for(i in c_d.indices){
            cube[0][c_d[i]] = cb.cube[0][c_d[i]]
            cube[2][c_d[i]] = cb.cube[2][c_d[i]]
            cube[5][c_d[i]] = cb.cube[5][c_d[i]]
            cube[1][c_d[i]] = cb.cube[1][c_d[i]]
        }
    }

    fun rotateL(){
        // rotate left:
        // Transition:
        val from = arrayOf(0,1,2,5,8,7,6,3,0,4)
        val to = arrayOf(2,5,8,7,6,3,0,1,2,4)
        val cp = CharArray(9)

        for(i in from.indices)
            cp[to[i]] = cube[4][from[i]]
        for(i in cp.indices)
            cube[4][i] = cp[i]

        // UFBRLD
        // 012345
        val cb = Cube()
        val c_d=arrayOf(0,3,6)

        for(i in c_d.indices) {
            cb.cube[1][c_d[i]] = cube[0][c_d[i]]
            cb.cube[5][c_d[i]] = cube[1][c_d[i]]
            cb.cube[2][c_d[i]] = cube[5][c_d[i]]
            cb.cube[0][c_d[i]] = cube[2][c_d[i]]
        }
        // Copy back
        for(i in c_d.indices) {
            cube[0][c_d[i]] = cb.cube[0][c_d[i]]
            cube[2][c_d[i]] = cb.cube[2][c_d[i]]
            cube[5][c_d[i]] = cb.cube[5][c_d[i]]
            cube[1][c_d[i]] = cb.cube[1][c_d[i]]
        }
    }

    fun rotateD(){
        // rotate top:
        // Transition:
        val from = arrayOf(0,1,2,5,8,7,6,3,0,4)
        val to = arrayOf(2,5,8,7,6,3,0,1,2,4)
        val cp = CharArray(9)

        for(i in from.indices)
            cp[to[i]] = cube[5][from[i]]
        for(i in cp.indices)
            cube[5][i] = cp[i]

        // Move UFBRLD
        val cb = Cube()
        val c_d=arrayOf(6,7,8)

        for(i in c_d.indices) {
            cb.cube[3][c_d[i]] = cube[1][c_d[i]]
            cb.cube[2][c_d[i]] = cube[3][c_d[i]]
            cb.cube[4][c_d[i]] = cube[2][c_d[i]]
            cb.cube[1][c_d[i]] = cube[4][c_d[i]]
        }

        // Copy back
        for(i in c_d.indices){
            cube[1][c_d[i]] = cb.cube[1][c_d[i]]
            cube[2][c_d[i]] = cb.cube[2][c_d[i]]
            cube[3][c_d[i]] = cb.cube[3][c_d[i]]
            cube[4][c_d[i]] = cb.cube[4][c_d[i]]
        }
    }

    fun rotate(how: Char){
        when(how) {
            'F' -> rotateF()
            'U' -> rotateU()
            'B' -> rotateB()
            'R' -> rotateR()
            'L' -> rotateL()
            'D' -> rotateD()
            else -> throw IllegalArgumentException("Use one of UFBRLD")
        }
    }

    fun isIdentical(other: Cube): Boolean {
        for (i in cube.indices) {
            for(j in cube[i].indices)
                if (cube[i][j] != other.cube[i][j])
                    return false
        }
        return true
    }

    override fun equals(other: Any?): Boolean {
        if( other is Cube )
            return isIdentical(other)

        return false
    }

    /*
     // How encode the rotations?
     Front-face turn clockwise:
     For
     c[f]:(0,1,2,5,8,7,6,3,0)->(2,5,8,7,6,3,0,1,2)
     c[r]:(0,3,6)->c[d](0,1,2)
     c[l]:(2,5,8)->c[u](6,7,8)
     c[u]:(6,7,8)->c[r](0,3,6)
     c[d]:(0,1,2)->c[l](2,5,8)

     Then I could invent some invariants:
     - Any face turned four times should come up identical
     - Any sequence forward then backward should come up identical

     Turning the cube, then turning a face (say front) then turn the cube again - should
     translate to turning another face (say left).
     */

    /*
     A cube is a 3x3x3.
     - I'll Use a 6x9 tables.
        A cube-face looks:
        0 1 2
        3 4 5
        6 7 8
     - Given an orientation of the cube, numbers are mapped as if:
       - Up: Tipped towards viewer
       - Down: Tipped from viewer
       - Right/left: Both turned directly towards viewer
       - Back - Turned 180degrees around the up/down axis towards the viewer.

     - Valid letters r,g,b,y,o,w
     - Tiles can be numbered 1-6.
     - "Get tile i" can be useful.
     - Connectivity, or moves. How describe?
       - All moves are "clockwise"
       - U F B R L D is the standard notation, with ' denoting counter clockwise.
       - How 'rotate' these, if the entire dice is rotated along x, y, z axis?

     - Rotating a face, moves first:
       0 -> 2, 1->5, 2-> 5->7
     */


    /*
    SEARCH ALGORITHM

    Searching from a solved cube to the starting point, might be a better option than searching from
    the starting point towards the solved cube.

    How about unsolvable cubes? How detect they are non-discoverable? Not feasable.

    From any position, there's are six neighbours.
    There's rotational symmetries; each rotation can be identifed by color of up-face and front face.


    */
}



class App {
    val greeting: String
        get() {
            return "Hello World!"
        }
}

fun main() {
    println(App().greeting)
}
