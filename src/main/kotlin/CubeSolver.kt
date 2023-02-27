import java.util.PriorityQueue

class CubeSolver() {

    val movesMapping = mapOf<Int, Int>(0 to 1, 1 to 0, 2 to 3, 3 to 2, 4 to 5, 5 to 4)

    /* Algorithm to solve the rubiks cube
    * to be implemented in A2 */
    fun solve(root: Node): Int {
        val initialDepth: Int = root.evaluation.toInt()
        println("Initial Depth: $initialDepth")
        val nodeQueue = PriorityQueue<Node>(NodeComparator)
        if (root.isSolved) return 0

        for (depth in initialDepth..19) {
            for (i in 0..5) {
                nodeQueue.add(Node(root, root.state.clone(root.state.rubiksCubeModal), i, 1))
            }
            while (!nodeQueue.isEmpty()) {
                var parentNode: Node = nodeQueue.remove()
                if (parentNode.isSolved) return parentNode.pathCost
                if (parentNode.pathCost < depth) {
                    for (i in 0..5) {
                        if (i == movesMapping[parentNode.lastMove]) continue else nodeQueue.add(
                            Node(
                                parentNode,
                                parentNode.state.clone(parentNode.state.rubiksCubeModal),
                                i,
                                parentNode.pathCost + 1
                            )
                        )
                    }
                }

            }
        }



        return -1
    }

}