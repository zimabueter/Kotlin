fun main() {
    print(nNumber(327))
}

fun nNumber(n: Int): Int {
    var sumNumber = n
    var multNumber = n
    var sum = 0
    var multiply = 1
    while (sumNumber > 0) {
        val r = sumNumber % 10
        sum += r
        sumNumber /= 10
    }
    while (multNumber != 0) {
        val r = multNumber % 10
        multiply= multiply * r
        multNumber /= 10
    }
    return multiply- sum
}
