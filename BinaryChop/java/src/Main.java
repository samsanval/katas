public class Main{

    public static void main(String[] args){

        int[] array = {1,2,3,5,6,9,10};
        BinaryChop binaryChop = new BinaryChop();
        int resultado = binaryChop.binaryChop(6,array);
        System.out.println("El resultado es "+resultado);
    }
}