#include "BinaryChop.h"
#include <stdio.h>
#include <stdlib.h>
#include <iostream>

using namespace std;

int main()
{
    int arrayTest[6]= {1,2,3,5,6,8};
    BinaryChop binaryChop;
    int arraySize = *(&arrayTest+1) - arrayTest;
    int result = binaryChop.chop(6,arrayTest, arraySize);
    cout << result;

}