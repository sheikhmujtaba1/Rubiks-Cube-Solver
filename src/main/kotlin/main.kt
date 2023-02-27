fun main() {
    val cube = RubiksCube()
    for (row in cube.rubiksCubeModal) {
        println(row.contentToString())
    }
    print("-------------\n")
    cube.verticalBackClockwise()
    cube.reset()
    cube.randomize(5)
//    cube.rotate(0)
//    cube.printCube()
//    cube.rotate(2)
   // cube.printCube()
    val rootNode = Node(null, cube, -1, 0);
    val solver = CubeSolver()
    print(solver.solve(rootNode))

}