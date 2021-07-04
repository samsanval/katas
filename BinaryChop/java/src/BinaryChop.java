public class BinaryChop {

    public int binaryChop(int number, int[] array)
    {
        int left = 0;
        int right = array.length-1;
        int middle = (right+left) / 2;
        int found = -2;
        do {
            if(array[middle] < number){
                left = middle +1;
                middle = (right+left)/2;
            }
            else if(array[middle] > number) {
                right = middle -1 ;
                middle = (right+left)/2;
            }
            else if(array[middle] == number) {
                return middle;
            }
            else if(left == right){
                found = -1;
            }
        } while(found == -2);
        return  found;
    }
}