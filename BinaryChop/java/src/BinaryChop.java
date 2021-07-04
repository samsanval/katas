public class BinaryChop {

    public int binaryChop(int number, int[] array)
    {
        int left = 0;
        int right = array.length-1;
        int middle = (right+left) / 2;
        int found = -1;
        do {
            if(array[middle] > number){
                left = middle +1;
                middle = (right+left)/2;
            }
            else if(array[middle] < number) {
                right = middle -1 ;
                middle = (right+left)/2;
            }
            else if(array[middle] == number) {
                return middle;
            }
        } while(left!=right);
        return  found;
    }
}