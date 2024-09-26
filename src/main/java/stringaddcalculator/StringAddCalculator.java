package stringaddcalculator;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static int splitAndSum(String text){

        if (text == null) return 0;

        String delimiter = ",|:";

        Map<String, String> delimiterAndTextMap = getCustomDelimiterAndText(delimiter, text);
        delimiter = delimiterAndTextMap.get("delimiter");
        text = delimiterAndTextMap.get("text");

        if (text.equals("")) return 0;

        String[] tokens = text.split(delimiter);
        return getSumResult(tokens);
    }

    private static int getSumResult(String[] tokens) {
        int result = 0;

        for(int i = 0; i < tokens.length; i++){
            try{
                int number = Integer.parseInt(tokens[i]);
                if (number < 0) throw new RuntimeException("음수 입력");
                result += number;
            }catch (RuntimeException e){
                throw new RuntimeException("계산 실패");
            }
        }
        return result;
    }

    private static Map<String,String> getCustomDelimiterAndText(String delimiter, String text) {
        Map<String, String> result = new HashMap<>();

        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (matcher.find()) {
            delimiter = matcher.group(1);
            text = matcher.group(2);
        }

        result.put("delimiter", delimiter);
        result.put("text", text);

        return result;
    }
}
