import {performance} from "perf_hooks";

const binaryChop = (num: number, array: number[]): number =>
{
    let left: number = 0;
    let right: number = array.length - 1;
    let middle: number = Math.trunc((left + right)/2);
    let found: number = -2;
    while(found === -2) {
        if(array[middle] < num ){
            left = middle + 1;
            middle = Math.trunc((left + right)/2);
        }
        else if(array[middle] > num) {
            right = middle -1;
            middle = Math.trunc((left + right)/2);

        }
        else if(array[middle] === num) {
            return middle;
        }
        else if(left === right) {
            found = -1;
        }
    }
    return found;
}

const binaryChopRecursive = (num: number, array: number[], left:number, right:number): number =>
{
    if(left > right) {
        return -1;
    }
    const middle = Math.trunc((right+left) / 2);
    if(array[middle] == num ){
        return middle;
    }
    if(array[middle] < num ){
        left = middle +1;
    }
    if(array[middle] > num) {
        right = middle - 1;
    }
    return binaryChopRecursive(num,array,left,right);
}

const numbers = [];
for(let i = 0; i< 10000; i++){
    numbers[i] = i;
}
const iterative = performance.now();
const resultIterative = binaryChop(0, numbers);
const iterativeEnd = performance.now();

console.log(`El resultado es ${resultIterative}`);
console.log(iterativeEnd - iterative);
const recursive = performance.now();
const recursiveResult = binaryChopRecursive(0,numbers,0,numbers.length-1);
const recursiveEnd = performance.now();

console.log(`El resultado recursivo es ${recursiveResult}`);
console.log(recursiveEnd - recursive);
