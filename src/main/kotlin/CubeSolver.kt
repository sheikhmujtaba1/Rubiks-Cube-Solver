import java.util.PriorityQueue

class CubeSolver() {

    /* Mapping so that we do not reverse the previous move */
    val movesMapping = mapOf<Int, Int>(0 to 1, 1 to 0, 2 to 3, 3 to 2, 4 to 5, 5 to 4)

    /* Algorithm to solve the rubiks cube */
    fun solve(root: Node): Int {
        val initialDepth: Int = root.evaluation.toInt()
        val nodeQueue = PriorityQueue<Node>(NodeComparator)
        if (root.isSolved) {
            println("Nodes expanded: 0")
            return 0
        }

        var nodesExpanded: Int = 0
        for (depth in initialDepth..15) {
            for (i in 0..5) {
                nodeQueue.add(Node(root, root.state.clone(root.state.rubiksCubeModal), i, 1))
            }

            while (!nodeQueue.isEmpty()) {
                val parentNode: Node = nodeQueue.remove()
                if (parentNode.isSolved) {
                    println("Nodes Expanded: $nodesExpanded,")
                    val solutionPath: List<Int> = solutionPath(parentNode)
                    println("Solution path: $solutionPath")
                    return parentNode.pathCost
                }
                nodesExpanded += 1
                for (i in 0..5) {
                    if (i == movesMapping[parentNode.lastMove]) continue
                    else {
                        val childNode: Node = Node(
                            parentNode,
                            parentNode.state.clone(parentNode.state.rubiksCubeModal),
                            i,
                            parentNode.pathCost + 1
                        )
                        if (childNode.isSolved) {
                            println("Nodes Expanded: $nodesExpanded,")
                            val solutionPath: List<Int> = solutionPath(childNode)
                            println("Solution path: $solutionPath")
                            return childNode.pathCost
                        }
                        if (childNode.evaluation < depth) nodeQueue.add(childNode)

                    }
                }

            }
        }

        return -1
    }

    fun solutionPath(node: Node): List<Int> {
        val moveList: MutableList<Int> = mutableListOf(node.lastMove)
        var currentNode: Node? = node.parentNode
        while (currentNode?.parentNode != null) {
            moveList.add(currentNode!!.lastMove)
            currentNode = currentNode.parentNode
        }
        return moveList
    }

}