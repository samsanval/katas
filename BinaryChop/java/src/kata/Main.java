package kata;

public class Main {

    public static void main(String[] args) {
        int[] array;
        array = new int[10000];
        for(int i = 0; i < 10000; i++){
            array[i] = i;
        }

        BinaryChop binaryChop = new BinaryChop();
        long startTimeIterative = System.nanoTime();
        int resultado = binaryChop.binaryChop(0,array);
        long endTimeIterative = System.nanoTime();
        System.out.println("El resultado es "+resultado);
        long totalTimeIterative = endTimeIterative-startTimeIterative;
        System.out.println("Execution time: "+totalTimeIterative);

        long startTimeRecursive = System.nanoTime();
        int resultRecursive = binaryChop.binaryChopRecursive(0,array,0,array.length-1);
        long endTimeRecursive = System.nanoTime();
        long totalTimeRecusive = endTimeRecursive-startTimeRecursive;
        System.out.println("El resultado recursivo es "+resultRecursive);
        System.out.println("Execution time: "+totalTimeRecusive);

    }
}
