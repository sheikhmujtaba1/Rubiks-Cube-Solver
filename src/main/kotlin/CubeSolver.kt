import java.util.PriorityQueue

class CubeSolver(originalCube: RubiksCube) {

    private val cube: RubiksCube = originalCube
    private val goalState: List<Array<String>> =
        List(6) { i -> Array<String>(4) { CubeColors.values()[i].printableName } }

    /* Algorithm to solve the rubiks cube
    * to be implemented in A2 */
    fun solve(): Unit {
        val nodeQueue = PriorityQueue<Node>(NodeComparator)
        val rootNode = Node(null, cube, -1, 0);
        val childNode: Node = Node(
            rootNode,
            rootNode.state.clone(rootNode.state.rubiksCubeModal), 0,
            rootNode.pathCost + 1)
        val childNode1: Node = Node(
            rootNode,
            rootNode.state.clone(rootNode.state.rubiksCubeModal), 1,
            rootNode.pathCost + 1)
        val childNode2: Node = Node(
            rootNode,
            rootNode.state.clone(childNode1.state.rubiksCubeModal), 7,
            rootNode.pathCost + 1)
        nodeQueue.add(childNode)
        nodeQueue.add(childNode1)
        nodeQueue.add(childNode2)

        while(!nodeQueue.isEmpty()) {
            println(nodeQueue.remove().evaluation)
        }

        return
    }

}