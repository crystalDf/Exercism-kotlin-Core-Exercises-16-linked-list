class Deque<T> {

    private var first: Node<T>? = null
    private var last: Node<T>? = null

    fun push(value: T) =
            last.let {
                last = Node(value, previous = it)
                it?.next = last
                first = first ?: last
            }

    fun pop(): T? =
            last.let {
                last = it?.previous
                last?.next = null
                first = if (last == null) null else first
                it?.value
            }

    fun unshift(value: T) =
            first.let {
                first = Node(value, next = it)
                it?.previous = first
                last = last ?: first
            }

    fun shift(): T? =
            first.let {
                first = it?.next
                first?.previous = null
                last = if (first == null) null else last
                it?.value
            }

    private data class Node<T> (val value: T, var next: Node<T>? = null, var previous: Node<T>? = null)
}
