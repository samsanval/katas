import kotlin.system.measureNanoTime

var arraySearch: IntArray = IntArray(10000) { i -> i}
val bc: BinaryChop = BinaryChop()
var result = -1
var executionTimeIterative = measureNanoTime {
    result = bc.binaryChop(0, arraySearch)

}
println("El resultado es $result")
println(executionTimeIterative)
var resultRecursive = -1
var executionTimeRecursive = measureNanoTime {
    resultRecursive = bc.binaryChopRecursive(0, arraySearch, 0, arraySearch.size -1)

}
println("El resultado es $resultRecursive")
println(executionTimeRecursive)
