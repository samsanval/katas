import sys
import time


def binary_chop(number: int, arraysearch: list) -> int:
    left = 0
    right = len(arraysearch) - 1
    middle = (right + left) // 2
    found = -2
    while found == -2:
        if arraysearch[middle] < number:
            left = middle + 1
            middle = (right + left) // 2
        elif arraysearch[middle] > number:
            right = middle - 1
            middle = (right + left) // 2
        elif arraysearch[middle] == number:
            return middle
        elif left == right:
            found = -1
    return found


def binary_chop_recursive(number: int, arraysearch: list, left: int, right: int) -> int:
    if left == right:
        return -1
    middle = (right + left) // 2
    if arraysearch[middle] == number:
        return middle
    if arraysearch[middle] < number:
        left = left + 1
    if arraysearch[middle] > number:
        right = right - 1
    return binary_chop_recursive(number, arraysearch, left, right)


array = [i for i in range(10000)]
start_time_iterative = time.time()
print('El resultado es ', format(binary_chop(0, array)))
print(f'Execution time iterative {time.time() - start_time_iterative}')
sys.setrecursionlimit(100000)
start_time_recursive = time.time()
print('El resultado recursivo es ', format(binary_chop_recursive(6, array, 0, len(array))))
print(f'Execution time recursive {time.time() - start_time_iterative}')
