#include "BinaryChop.h"
#include <iostream>

using namespace std;

int BinaryChop::chop(int number, std::vector<int> &arrayToSearch, int arraySize)
{
    int left = 0;
    int right = arraySize-1;
    int middle = (right+left) /2;
    int found = -2;
    while(found == -2)
    {
        if (arrayToSearch[middle] < number) {
            left = middle+1;
            middle = (right+left)/2;
        }
        else if (arrayToSearch[middle] > number) {
            right = middle -1 ;
            middle = (right+left)/2;

        }
        else if (arrayToSearch[middle] == number){
            return middle;
        }
        else if(left > right) {
            found = -1;
        }
    }
    return found;
}

int BinaryChop::chopRecursive(int number, std::vector<int> &array, int left, int right)
{
    if(left > right) {
        return -1;
    }
    int middle = (right+left) /2;
    if(array[middle] == number ){
        return middle;
    }
    if(array[middle] < number) {
        left = middle + 1;
    }
    if(array[middle] > number ){
        right = middle - 1;
    }
    return chopRecursive(number,array,left,right);
}