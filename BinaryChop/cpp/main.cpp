#include "BinaryChop.h"
#include <stdio.h>
#include <stdlib.h>
#include <iostream>
#include <vector>
#include <chrono>


using namespace std;
using namespace std::chrono;

int main()
{
    vector<int> arrayTest (10000);
    for(int i = 0; i < 10000; i++) {
        arrayTest[i] = i;
    }
    BinaryChop binaryChop;
    int arraySize = arrayTest.size();
    auto startIterative = high_resolution_clock::now();
    int result = binaryChop.chop(0,arrayTest, arraySize);
    auto stopIterative = high_resolution_clock::now();
    auto duration = duration_cast<nanoseconds>(stopIterative - startIterative);

    cout << "El resultado es :" << result << endl;
    cout << "Execution time " << duration.count() << endl;
    auto startRecursive = high_resolution_clock::now();
    int resultRecursive = binaryChop.chopRecursive(0,arrayTest,0,arraySize-1);
    auto stopRecursive = high_resolution_clock::now();
    auto durationRecursive = duration_cast<nanoseconds>(stopRecursive - startIterative);

    cout << "El resultado recursivo es: " << resultRecursive << "\n";
    cout << "Execution time " << durationRecursive.count() << endl;


}