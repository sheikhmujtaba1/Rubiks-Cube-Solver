class Node(
    parentNode: Node? = null,
    cubeState: RubiksCube,
    lastMove: Int,
    pathCost: Int
) {
    init {
        cubeState.rotate(lastMove)
    }

    val parentNode: Node? = parentNode
    val state: RubiksCube = cubeState
    val pathCost: Int = pathCost
    val evaluation: Float = cubeState.evaluateHeuristic() + pathCost
    val lastMove: Int = lastMove
    val isSolved: Boolean = cubeState.isSolved()
}