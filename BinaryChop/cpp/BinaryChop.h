#include <vector>

using namespace std;

class BinaryChop
{
    public:
        int chop(int number, std::vector<int> &array, int arraySize);
        int chopRecursive(int number, std::vector<int> &array, int left, int right);
};