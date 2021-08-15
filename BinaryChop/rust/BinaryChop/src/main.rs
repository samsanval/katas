use std::time::{Instant};

fn binary_chop(number: usize, array: &[usize] ) -> isize
{
    let mut left = 0;
    let mut right = array.len() - 1;
    let mut middle = (right + left) / 2;
    let mut found = -2 as isize;
    while found == -2 {
        if array[middle] < number {
            left = middle + 1;
            middle = (right + left) / 2;
        }
        else if array[middle] > number {
            right = middle - 1 ;
            middle = (right + left) / 2;
        }
        else if array[middle] == number {
            found = middle as isize;
        }
        else if left > right {
            found = -1;
        }
    }
    return found;

}

fn binary_chop_recursive(number: usize, array: &[usize], left: usize, right: usize) -> isize
{
    if left > right {
        return -1;
    }
    let middle = (right + left) /2;
    if array[middle] == number {
        return middle as isize;
    }
    let mut newleft = left;
    let mut newright = right;
    if array[middle] < number {
        newleft = middle + 1 as usize;
    }
    if array[middle] > number {
        newright = middle - 1 as usize;
    }
    return binary_chop_recursive(number, array, newleft, newright);
}

fn main() {
    let mut array:[usize; 10000] = [0; 10000];
    for i in 0..10000 {
        array[i] = i;
    }
    let start_time_iterative = Instant::now();
    let result = binary_chop(0, &array);
    print!("El resultado es {} con un tiempo de ejecución de {} \n", result, start_time_iterative.elapsed().as_secs_f64());

    let start_time_recursive = Instant::now();
    let result_recursive = binary_chop_recursive(0, &array, 0, array.len());
    print!("El resultado es {} con un tiempo de ejecución de {} \n", result_recursive, start_time_recursive.elapsed().as_secs_f64());
}
