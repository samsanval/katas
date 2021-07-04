package main

import "fmt"

func chop(number int, array []int) int {
	var left, right int
	left = 0
	right = len(array)-1
	var found int = -2
	var middle int = (right + left) /2
	for found == -2 {
		if number > array[middle] {
			left = middle +1
			middle = (right + left) /2
		} else if number < array[middle] {
			right = middle - 1
			middle = (right + left) /2
		} else if number == array[middle]{
			return middle
		} else if (left == right){
			found = -1
		}
	}
	return found
}

func main() {
	array := make([] int, 10)
	var i int = 0
	for i < 10 {
		array[i] = i
		i = i+1
	}
	fmt.Println(chop(0, array))
}