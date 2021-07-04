def binarychop (number, array):
    left = 0
    right = len(array)-1
    middle = (right+left) / 2
    found = -2
    while found == -2:
        if array[middle] < number:
            left = middle +1
            middle = (right+left) / 2
        elif array[middle] > number:
            right = middle- 1
            middle = (right+left) / 2
        elif array[middle] == number:
            return middle
        elif left == right:
            found = -1
    return found

array = list((1,2,3,4,5,7))
print(binarychop(1,array))
        

