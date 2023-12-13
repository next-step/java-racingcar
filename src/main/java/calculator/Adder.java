package calculator;

public class Adder {
    protected int sumInts(int[] parsedNumbers){
        int sum = 0;
        for (int parsedNumber : parsedNumbers) {
            sum += parsedNumber;
        }
        return sum;
    }
}
