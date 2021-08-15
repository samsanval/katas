var binaryChop = function (num, array) {
    var left = 0;
    var right = array.length - 1;
    var middle = Math.trunc((right + left) / 2);
    var found = -2;
    do {
        console.log(middle);
        if (array[middle] < num) {
            left = middle + 1;
            middle = (right + left) / 2;
        }
        else if (array[middle] > num) {
            right = middle - 1;
            middle = (right + left) / 2;
        }
        else if (array[middle] === num) {
            return middle;
        }
        else if (left === right) {
            found = -1;
        }
    } while (found === -2);
    return found;
};
var binaryChopRecursive = function (num, array, left, right) {
    if (left > right) {
        return -1;
    }
    var middle = Math.trunc((right + left) / 2);
    if (array[middle] == num) {
        return middle;
    }
    if (array[middle] < num) {
        left = middle + 1;
    }
    if (array[middle] > num) {
        right = middle - 1;
    }
    return binaryChopRecursive(num, array, left, right);
};
var numbers = [];
for (var i = 0; i < 10000000; i++) {
    numbers[i] = i;
}
console.time('iterative');
console.log("El resultado es " + binaryChop(6, numbers));
console.timeEnd('iterative');
console.time('recursive');
console.log("El resultado recursivo es " + binaryChopRecursive(6, numbers, 0, numbers.length - 1));
console.timeEnd('recursive');
