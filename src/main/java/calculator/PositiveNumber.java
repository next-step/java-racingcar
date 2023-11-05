package calculator;

public class PositiveNumber {

    int[] positiveNums;

    public PositiveNumber(String[] values){
        positiveNums = new int[values.length];

        for(int i=0; i<values.length; i++){
            positiveNums[i] = Integer.parseInt(values[i]);
            checkNegative(positiveNums[i]);
        }
    }

    private static void checkNegative(int number) {
        if(number < 0){
            throw new RuntimeException();
        }
    }
}
