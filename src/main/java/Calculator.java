import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.*;

public class Calculator {

    static int splitAndSum(String inputData) {
        if (checkIfEmpty(inputData)) {
            return 0;
        }

        List<String> elements = splitText(inputData);

        return sumAll(elements);
    }

    private static boolean checkIfEmpty(String text) {
        return  text == null || text.isEmpty();
    }

    private static List<String> splitText (String inputData){
        String delimiter, realText;

        final Matcher m = Pattern.compile("//(.)\n(.*)").matcher(inputData);
        if (m.find()) {
            delimiter = m.group(1);
            realText = m.group(2);
        } else {
            delimiter = ",|:";
            realText = inputData;
        }

        return Arrays.asList(realText.split(delimiter));
    }

    private static int sumAll (List<String> strings) {
        return convertStringArrayToIntArray(strings).stream().mapToInt(Integer::intValue).sum();
    }

    private static List<Integer> convertStringArrayToIntArray(List<String> inputString) {
        List<Integer> output = new ArrayList<>();
        for (String el : inputString) {
            int number = Integer.parseInt(el);
            if (number < 0) {
                throw new IllegalArgumentException("입력값은 양수로 입력해야 합니다.");
            }
            output.add(number);
        }

        return output;
    }

}
