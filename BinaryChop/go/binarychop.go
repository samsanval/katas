package main

import (
	"fmt"
	"time"
)

func chop(number int, array []int) int {
	var left, right int
	left = 0
	right = len(array) - 1
	var found = -2
	var middle = (right + left) / 2
	for found == -2 {
		if number > array[middle] {
			left = middle + 1
			middle = (right + left) / 2
		} else if number < array[middle] {
			right = middle - 1
			middle = (right + left) / 2
		} else if number == array[middle] {
			return middle
		} else if left == right {
			found = -1
		}
	}
	return found
}

func chopRecursive(number int, array []int, left int, right int) int {
	if left == right {
		return -1
	}
	var middle = (right + left) / 2
	if array[middle] == number {
		return middle
	}
	if array[middle] < number {
		left = middle + 1
	}
	if array[middle] > number {
		right = middle - 1
	}
	return chopRecursive(number, array, left, right)
}

func main() {
	array := make([]int, 10000)
	var i = 0
	for i < 10000 {
		array[i] = i
		i = i + 1
	}
	startIterative := time.Now()
	fmt.Println(chop(3, array))
	endTimeIterative := time.Since(startIterative)
	fmt.Printf("Execution time iterative %d \n", endTimeIterative.Nanoseconds())
	startRecursive := time.Now()
	fmt.Println(chopRecursive(3, array, 0, len(array)))
	endTimeRecursive := time.Since(startRecursive)
	fmt.Printf("Execution time recursive %d \n", endTimeRecursive.Nanoseconds())

}
