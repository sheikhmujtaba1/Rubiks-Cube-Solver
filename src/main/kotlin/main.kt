fun main() {
    val cube = RubiksCube()
    for (row in cube.rubiksCubeModal) {
        println(row.contentToString())
    }
    print("-------------\n")
    cube.verticalBackClockwise()

    println(cube.isSolved())
    cube.reset()
    //cube.randomize(2)
    val solver = CubeSolver(cube)
    solver.solve()
}