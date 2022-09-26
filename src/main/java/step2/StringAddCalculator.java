package step2;

public class StringAddCalculator {

    public static int splitAndSum(String text) {
        int[] intArray = Split.splitStringToIntArray(text);
        return Sum.addAllValuesInIntArray(intArray);
    }
}
