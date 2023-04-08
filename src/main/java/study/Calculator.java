package study;

import org.w3c.dom.Text;

public class Calculator {
    public static int SplitSum(String text) {

        text = GetNotNull(text);
        String[] textSplit = text.split(",|:|;|//|\\n");
        int sum = GetSum(textSplit);

        return sum;
    }

    private static String GetNotNull(String text) {
        if(text == null || text.isEmpty()){
            return "0";
        }
        return text;
    }

    private static int GetSum(String[] textSplit) {
        int sum=0;
        for(int i = 0; i< textSplit.length; i++){

            String notNull = GetNotNull(textSplit[i]);
            String positive = GetPositive(notNull);
            sum += GetNumbers(positive);
        }
        return sum;
    }

    private static String GetPositive(String textSplit) {
        if(GetNumbers(textSplit)<0){
            return "RuntimeException";
        }
        return textSplit;
    }

    private static int GetNumbers(String textSplit) {
        int numbers = Integer.parseInt(textSplit);
        return numbers;
    }
}
