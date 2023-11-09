package study;

public class StringAddCalculator {

    private static final int NULL_EMPTY_NUM = 0;


    private StringAddCalculator() {
    }


    public static int splitAndSum(String text) {
        if (text == null || text.isEmpty()){
            return NULL_EMPTY_NUM;
        }


        return sum(getNumbers(customDelimiter(text)));
    }

    private static String[] customDelimiter(String text){
        int sIdx = text.indexOf("//")+2;
        int eIdx = text.indexOf("\n");
        String delimiter = "[,:]";

        if (eIdx > 0){
            delimiter = text.substring(sIdx, eIdx);
        }

        text = text.replace("//;\n", "");
        return text.split(delimiter);
    }

    private static int[] getNumbers(String[] list){
        int[] numbers = new int[list.length];
        for (int i = 0; i < list.length; i++) {
            numbers[i] = Integer.parseInt(list[i]);
        }
        return numbers;
    }

    private static int sum(int[] numbers) {
        int result = 0;

        for (int num : numbers) {
            negativeException(num);
            result += num;
        }

        return result;
    }


    private static void negativeException(int num){
        //음수가 입력되었을 경우 RuntimeException 발생

        if (num < 0){
            throw new RuntimeException();
        }
    }

}
