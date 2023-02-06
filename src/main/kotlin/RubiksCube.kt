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
    var rubiksCubeModal: Array<Array<String>> =
        Array(6) { i -> Array<String>(4) { CubeColors.values()[i].printableName } }

    /* variable to store a deep copy of the current state of the rubiks cube */
    var cubeDeepCopy: List<Array<String>> = rubiksCubeModal.map { it.clone() }


    /* Resets the rubiks cube back to a solved state*/
    fun reset(): Unit {
        rubiksCubeModal = Array(6) { i -> Array<String>(4) { CubeColors.values()[i].printableName } }
    }

    /*Checks whether the rubiks cube is solved and returns a boolean*/
    fun isSolved(): Boolean {
        rubiksCubeModal.forEach { if (it.distinct().count() != 1) return false }
        return true
    }

    /* */
    fun verticalClockwise(): Unit {
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

    fun verticalAntiClockwise(): Unit {
        for (i in 0..2) {
            verticalClockwise()
        }
    }

    fun verticalBackClockwise(): Unit {
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

    fun verticalBackAntiClockwise(): Unit {
        for (i in 0..2) {
            verticalBackClockwise()
        }
    }

    fun verticalLeftFrontRotation(): Unit {
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

    fun verticalLeftBackRotation(): Unit {
        for (i in 0..2) {
            verticalLeftFrontRotation()
        }
    }

    fun verticalRightFrontRotation(): Unit {
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

    fun verticalRightBackRotation(): Unit {
        for (i in 0..2) {
            verticalRightFrontRotation()
        }
    }

    fun horizontalTopClockwise(): Unit {
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

    fun horizontalTopAntiClockwise(): Unit {
        for (i in 0..2) {
            horizontalTopClockwise()
        }
    }

    fun horizontalBottomClockwise(): Unit {
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

    fun horizontalBottomAntiClockwise(): Unit {
        for (i in 0..2) {
            horizontalBottomClockwise()
        }
    }

    fun printCube(): Unit {
        print(rubiksCubeModal[4][2]+ " " + rubiksCubeModal[4][3] + "\n" +
                rubiksCubeModal[4][0] + " " + rubiksCubeModal[4][1]+ "\n")
        print(rubiksCubeModal[3][2] + " " + rubiksCubeModal[3][3]+ " ")
        for (i in 0..2) {
            print(rubiksCubeModal[i][2] + " " + rubiksCubeModal[i][3]+ " ")
        }
        print("\n"+rubiksCubeModal[3][0] + " " + rubiksCubeModal[3][1]+ " ")
        for (i in 0..2) {
            print(rubiksCubeModal[i][0] + " " + rubiksCubeModal[i][1]+ " ")
        }
        print("\n" + rubiksCubeModal[5][2]+ " " + rubiksCubeModal[5][3] + "\n" +
                rubiksCubeModal[5][0] + " " + rubiksCubeModal[5][1])
    }

    /* Algorithm to solve the rubiks cube */
    fun solve(): Unit {
        return
    }

    fun copyCube(): List<Array<String>> {
        return rubiksCubeModal.map { it.clone() }
    }

    /* Perform random k rotations to shuffle the cube */
    fun randomize(k: Int): Unit {

    }
}