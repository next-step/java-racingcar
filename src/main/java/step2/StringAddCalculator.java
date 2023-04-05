package step2;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class StringAddCalculator {

    public int splitAndSum(String text) throws RuntimeException{

        if(checkNullOrEmpty(text)){
            return 0;
        }

        int[] numbers = getNumberArr(text);

        for (int number : numbers) {
            if(number < 0){
                throw new RuntimeException("음수는 입력할 수 없습니다.");
            }
        }

        return addNumbers(numbers);
    }

    public boolean checkNullOrEmpty(String text){
        if(text == null || text.isEmpty()){
            return true;
        }
        return false;
    }

    public int addNumbers(int[] numbers){
        return IntStream.of(numbers).sum();
    }

    public int[] getNumberArr(String text){
        String delimiter = "";
        String[] tokens;

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            delimiter = m.group(1);
            tokens = m.group(2).split(delimiter);
        } else{
            tokens = text.split(",|:");
        }

        return Arrays.stream(tokens)
                .mapToInt(Integer::parseInt)
                .toArray();
    }

}
