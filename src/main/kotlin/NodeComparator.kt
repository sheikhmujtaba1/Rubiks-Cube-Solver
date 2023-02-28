class NodeComparator {
    companion object : Comparator<Node> {
//        comparator for node based on evaluation = g(n) + h(n)
        override fun compare(p0: Node, p1: Node): Int = when {
            p0.evaluation != p1.evaluation -> p0.evaluation.toInt() - p1.evaluation.toInt()
            else -> 1
            }
    }
}