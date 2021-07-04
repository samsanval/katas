#include "BinaryChop.h"
#include <iostream>

using namespace std;

int BinaryChop::chop(int number, int arrayToSearch[], int arraySize)
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
        else if(left == right) {
            found = -1;
        }
    }
    return found;
}