class RubiksCube {
    /*
    * White -> Top Face [0]
    * Red -> Right Face [1]
    * Yellow -> Bottom Face [2]
    * Orange -> Left Face [3]
    * Blue -> Back Face [4]
    * Green -> Front Face [5]
    * */

    /* Rubiks Cube Modal using a 2d array representation*/
    var rubiksCubeModal: List<Array<String>> =
        List(6) { i -> Array<String>(4) { CubeColors.values()[i].printableName } }

    /* variable/data structure to store a deep copy of the current state of the rubiks cube */
    var cubeDeepCopy: List<Array<String>> = rubiksCubeModal.map { it.clone() }

    constructor()

    constructor(originalCube: List<Array<String>>) {
        rubiksCubeModal = originalCube
    }


    /* Resets the rubiks cube back to a solved state
    *  Input: None, Output: Unit/None*/
    fun reset() {
        rubiksCubeModal = List(6) { i -> Array<String>(4) { CubeColors.values()[i].printableName } }
    }

    /*Checks whether the rubiks cube is solved and returns a boolean
    *  Input: None, Output: Boolean */
    fun isSolved(): Boolean {
        rubiksCubeModal.forEach { if (it.distinct().count() != 1) return false }
        return true
    }

    /* Rotates the cube's front face clockwise
    *  Input: None, Output: Unit/None */
    fun verticalClockwise() {
        cubeDeepCopy = copyCube()
        for (i in 0..3) {
            if (i == 3) {
                rubiksCubeModal[0][0] = cubeDeepCopy[3][0]
                rubiksCubeModal[0][1] = cubeDeepCopy[3][1]
            } else {
                rubiksCubeModal[i + 1][0] = cubeDeepCopy[i][0]
                rubiksCubeModal[i + 1][1] = cubeDeepCopy[i][1]
            }
        }
        rubiksCubeModal[5][0] = cubeDeepCopy[5][1]
        rubiksCubeModal[5][1] = cubeDeepCopy[5][3]
        rubiksCubeModal[5][2] = cubeDeepCopy[5][0]
        rubiksCubeModal[5][3] = cubeDeepCopy[5][2]
    }

    /* Rotates the cube's front face Anti-clockwise
    *  Input: None, Output: Unit/None */
    fun verticalAntiClockwise() {
        for (i in 0..2) {
            verticalClockwise()
        }
    }

    /* Rotates the cube's back face clockwise
    *  Input: None, Output: Unit/None*/
    fun verticalBackClockwise() {
        cubeDeepCopy = copyCube()
        for (i in 0..3) {
            if (i == 3) {
                rubiksCubeModal[0][2] = cubeDeepCopy[3][2]
                rubiksCubeModal[0][3] = cubeDeepCopy[3][3]
            } else {
                rubiksCubeModal[i + 1][2] = cubeDeepCopy[i][2]
                rubiksCubeModal[i + 1][3] = cubeDeepCopy[i][3]
            }
        }
        rubiksCubeModal[4][0] = cubeDeepCopy[4][2]
        rubiksCubeModal[4][1] = cubeDeepCopy[4][0]
        rubiksCubeModal[4][2] = cubeDeepCopy[4][3]
        rubiksCubeModal[4][3] = cubeDeepCopy[4][1]
    }

    /* Rotates the cube's back face Anti-clockwise */
    fun verticalBackAntiClockwise() {
        for (i in 0..2) {
            verticalBackClockwise()
        }
    }

    /* Rotates the cube's left face clockwise
    *  Input: None, Output: Unit/None */
    fun verticalLeftFrontRotation() {
        cubeDeepCopy = copyCube()
        rubiksCubeModal[5][0] = cubeDeepCopy[0][0]
        rubiksCubeModal[5][2] = cubeDeepCopy[0][2]

        rubiksCubeModal[2][0] = cubeDeepCopy[5][0]
        rubiksCubeModal[2][2] = cubeDeepCopy[5][2]

        rubiksCubeModal[4][0] = cubeDeepCopy[2][0]
        rubiksCubeModal[4][2] = cubeDeepCopy[2][2]

        rubiksCubeModal[0][0] = cubeDeepCopy[4][0]
        rubiksCubeModal[0][2] = cubeDeepCopy[4][2]

        rubiksCubeModal[3][0] = cubeDeepCopy[3][1]
        rubiksCubeModal[3][1] = cubeDeepCopy[3][3]
        rubiksCubeModal[3][2] = cubeDeepCopy[3][0]
        rubiksCubeModal[3][3] = cubeDeepCopy[3][2]
    }

    /* Rotates the cube's left face Anti-clockwise
    *  Input: None, Output: Unit/None*/
    fun verticalLeftBackRotation() {
        for (i in 0..2) {
            verticalLeftFrontRotation()
        }
    }

    /* Rotates the cube's right face clockwise
    *  Input: None, Output: Unit/None */
    fun verticalRightFrontRotation() {
        cubeDeepCopy = copyCube()
        rubiksCubeModal[5][1] = cubeDeepCopy[0][3]
        rubiksCubeModal[5][3] = cubeDeepCopy[0][3]

        rubiksCubeModal[2][1] = cubeDeepCopy[5][1]
        rubiksCubeModal[2][3] = cubeDeepCopy[5][3]

        rubiksCubeModal[4][1] = cubeDeepCopy[2][1]
        rubiksCubeModal[4][3] = cubeDeepCopy[2][3]

        rubiksCubeModal[0][1] = cubeDeepCopy[4][1]
        rubiksCubeModal[0][3] = cubeDeepCopy[4][3]

        rubiksCubeModal[1][0] = cubeDeepCopy[3][2]
        rubiksCubeModal[3][1] = cubeDeepCopy[3][0]
        rubiksCubeModal[3][2] = cubeDeepCopy[3][3]
        rubiksCubeModal[3][3] = cubeDeepCopy[3][1]
    }

    /* Rotates the cube's right face Anti-clockwise
    *  Input: None, Output: Unit/None */
    fun verticalRightBackRotation() {
        for (i in 0..2) {
            verticalRightFrontRotation()
        }
    }

    /* Rotates the cube's top face clockwise
    * Input: None, Output: Unit/None */
    fun horizontalTopClockwise() {
        cubeDeepCopy = copyCube()
        rubiksCubeModal[5][2] = cubeDeepCopy[1][0]
        rubiksCubeModal[5][3] = cubeDeepCopy[1][2]

        rubiksCubeModal[1][0] = cubeDeepCopy[4][1]
        rubiksCubeModal[1][2] = cubeDeepCopy[4][0]

        rubiksCubeModal[4][0] = cubeDeepCopy[3][1]
        rubiksCubeModal[4][1] = cubeDeepCopy[3][3]

        rubiksCubeModal[3][1] = cubeDeepCopy[3][3]
        rubiksCubeModal[3][3] = cubeDeepCopy[3][2]

        rubiksCubeModal[0][0] = cubeDeepCopy[0][1]
        rubiksCubeModal[0][1] = cubeDeepCopy[0][3]
        rubiksCubeModal[0][2] = cubeDeepCopy[0][0]
        rubiksCubeModal[0][3] = cubeDeepCopy[0][2]
    }

    /* Rotates the cube's top face Anti-clockwise
    * * Input: None, Output: Unit/None */
    fun horizontalTopAntiClockwise() {
        for (i in 0..2) {
            horizontalTopClockwise()
        }
    }

    /* Rotates the cube's bottom face clockwise
    * * Input: None, Output: Unit/None */
    fun horizontalBottomClockwise() {
        cubeDeepCopy = copyCube()
        rubiksCubeModal[5][0] = cubeDeepCopy[1][1]
        rubiksCubeModal[5][1] = cubeDeepCopy[1][3]

        rubiksCubeModal[1][1] = cubeDeepCopy[4][3]
        rubiksCubeModal[1][3] = cubeDeepCopy[4][2]

        rubiksCubeModal[4][2] = cubeDeepCopy[3][0]
        rubiksCubeModal[4][3] = cubeDeepCopy[3][2]

        rubiksCubeModal[3][0] = cubeDeepCopy[5][1]
        rubiksCubeModal[3][2] = cubeDeepCopy[5][0]

        rubiksCubeModal[2][0] = cubeDeepCopy[2][1]
        rubiksCubeModal[2][1] = cubeDeepCopy[2][3]
        rubiksCubeModal[2][2] = cubeDeepCopy[2][0]
        rubiksCubeModal[2][3] = cubeDeepCopy[2][2]
    }

    /* Rotates the cube's bottom face clockwise
    * * Input: None, Output: Unit/None */
    fun horizontalBottomAntiClockwise() {
        for (i in 0..2) {
            horizontalBottomClockwise()
        }
    }

    /*Print the cube in a way where
    * The bottom face is on the extreme right
    * Top face is on the extreme left
    * Front face is on the bottom
    * Back face on the top
    * Input: None, Output: Unit/None */
    fun printCube() {
        print(
            "\n" + rubiksCubeModal[4][2] + " " + rubiksCubeModal[4][3] + "\n" +
                    rubiksCubeModal[4][0] + " " + rubiksCubeModal[4][1] + "\n"
        )
        print(rubiksCubeModal[3][2] + " " + rubiksCubeModal[3][3] + " ")
        for (i in 0..2) {
            print(rubiksCubeModal[i][2] + " " + rubiksCubeModal[i][3] + " ")
        }
        print("\n" + rubiksCubeModal[3][0] + " " + rubiksCubeModal[3][1] + " ")
        for (i in 0..2) {
            print(rubiksCubeModal[i][0] + " " + rubiksCubeModal[i][1] + " ")
        }
        print(
            "\n" + rubiksCubeModal[5][2] + " " + rubiksCubeModal[5][3] + "\n" +
                    rubiksCubeModal[5][0] + " " + rubiksCubeModal[5][1]
        )
    }

    /* Makes a deep copy of the cube*/
    fun copyCube(): List<Array<String>> {
        return rubiksCubeModal.map { it.clone() }
    }

    /* Perform random k rotations to shuffle the cube */
    fun randomize(k: Int) {
        var previousMove: Int
        var randomMove = 0
        for (i in 0..k) {
            previousMove = randomMove
            randomMove = (0..11).random()
            while (randomMove == previousMove) {
                randomMove = (0..11).random()
            }
            rotate(randomMove)
        }
    }

    /* provides a deep copy of the
     cube object */
    public fun clone(cubeState: List<Array<String>>): RubiksCube {
        val tempList = cubeState.map { it.clone() }
        return RubiksCube(tempList)
    }

    fun evaluateHeuristic(): Float {
        if (this.isSolved()) return 0.toFloat()
        val solvedCube: List<Array<String>> = List(6) { i -> Array<String>(4) { CubeColors.values()[i].printableName } }
        var unmatchedStickers: Int = 0
        for (i in solvedCube.indices) {
            for (j in 0 until solvedCube[0].size)
                if (solvedCube[i][j] != this.rubiksCubeModal[i][j]) unmatchedStickers += 1
        }
        return (unmatchedStickers / 8).toFloat()
    }

    fun rotate(move: Int) {
        when (move) {
            0 -> verticalClockwise()
            1 -> verticalAntiClockwise()
            2 -> verticalBackClockwise()
            3 -> verticalBackAntiClockwise()
            4 -> verticalLeftFrontRotation()
            5 -> verticalLeftBackRotation()
            6 -> verticalRightFrontRotation()
            7 -> verticalRightBackRotation()
            8 -> horizontalTopClockwise()
            9 -> horizontalTopAntiClockwise()
            10 -> horizontalBottomClockwise()
            11 -> horizontalBottomAntiClockwise()
        }
    }

}