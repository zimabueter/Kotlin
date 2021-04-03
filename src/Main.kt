fun main() {

    val p = Point(3.0, 8.0)

 p.xSymmetry()
    print(p)
}

class Point(private val x: Double, private var y: Double) {
    override fun toString(): String {
        return "Point(x=$x, y=$y)"
    }

    override fun equals(other: Any?): Boolean {
        if (other == null ||
                other !is Point ||
                x != other.x || y != other.y) return false

        return true
    }

    override fun hashCode(): Int {
        var result = x.hashCode()
        result = 31 * result + y.hashCode()
        return result
    }

    fun xSymmetry() {
        y *= -1
    }

}

