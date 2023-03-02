import kotlin.system.measureTimeMillis

fun main() {

//    cube.rotate(0)
//    cube.printCube()
//    cube.rotate(2)
    // cube.printCube()
//    var cube = RubiksCube()
//    cube.randomize(12)
//    val rootNode = Node(null, cube, -1, 0)
//    val solver = CubeSolver()
//    val elapsed = measureTimeMillis { println("Path cost: ${solver.solve(rootNode)}") }


    for (i in 0..15) {
        for (j in 0..10) {
            val cube = RubiksCube()
            cube.randomize(i)
            println("Scrambling depth: $i")
            print("Initial State:")
            cube.printCube()
            val rootNode = Node(null, cube, -1, 0)
            val solver = CubeSolver()
            val elapsed = measureTimeMillis { println("Solution cost: ${solver.solve(rootNode)}") }
            println("Time taken(ms): $elapsed\n")
        }
    }

}