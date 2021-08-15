class BinaryChop {

    fun binaryChop(number: Int, array: IntArray): Int
    {
        var left = 0
        var right = array.size
        var middle = (right+left)/2
        var found = -2
        while(found == -2) {
            if (array[middle] < number){
                left = middle + 1
                middle = (right + left) /2
            }
            if(array[middle] > number){
                right = middle - 1
                middle = (right + left) / 2
            }
            if(array[middle] == number){
                found = middle
            }
            if(left > right) {
                return -1
            }
        }
        return found
    }

    fun binaryChopRecursive(number: Int, array: IntArray, left: Int, right: Int): Int
    {
        if(left > right){
            return -1
        }
        val middle = (right+left) / 2
        if (array[middle] == number ){
            return middle;
        }
        var newLeft = left;
        var newRight = right;
        if(array[middle] < number ){
            newLeft = middle + 1
        }
        if(array[middle] > number) {
            newRight = middle - 1
        }
        return binaryChopRecursive(number, array, newLeft, newRight)
    }
}