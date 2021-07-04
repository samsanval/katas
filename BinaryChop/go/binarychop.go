package main

func chop(number int, array []int) int {
	var left, right int
	left = 0
	right = len(array)
	var found int = -2
	var middle int = (right + left) /2
	for left != right || found != -2 {
		if number < array[middle] {
			left = middle +1 
		}
		else if number > array[middle] {
			right = middle - 1
		}
		else if number == array[middle] || left == right {
			found = array[middle]
		}
	}
	return found
}

func main() {
	array := make([] int)
	var i int = 0
	for i < 100 {
		array[i] = i
		i = i+1
	}
	chop(6, array)
}