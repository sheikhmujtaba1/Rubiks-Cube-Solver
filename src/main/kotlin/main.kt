fun main() {
    val cube = RubiksCube()
    for (row in cube.rubiksCubeModal) {
        println(row.contentToString())
    }
    print("-------------\n")
    cube.verticalBackClockwise()
    for (row in cube.rubiksCubeModal) {
        println(row.contentToString())
    }
    println(cube.isSolved())
    cube.reset()
    for (row in cube.rubiksCubeModal) {
        println(row.contentToString())
    }
    cube.printCube()
}