fun main() {
    print(nNumber(-1))
}

fun nNumber(n: Int): Int {
    if (n==0) return 0
    var sumNumber = n
    var multNumber = n
    var sum = 0
    var multiply = 1
    while (sumNumber != 0) {
        val r = sumNumber % 10
        sum += r
        sumNumber /= 10
    }
    while (multNumber != 0) {
        val r = multNumber % 10
        multiply *= r
        multNumber /= 10
    }
    return multiply- sum
}
