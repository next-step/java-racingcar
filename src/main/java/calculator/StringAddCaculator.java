package calculator;

public class StringAddCaculator {

    public static int splitAndSum(String text) {
        int sum = 0;
        if(text == null || text.isEmpty()){
            return 0;
        }
        return getSum(toInts(text.split(",")));
    }

    private static int[] toInts(String[] textArray){
        int[] numbers = new int[textArray.length];
        for(int i = 0; i < textArray.length; i++){
            numbers[i] = Integer.parseInt(textArray[i]);
        }
        return numbers;
    }

    private static int getSum(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }
}
