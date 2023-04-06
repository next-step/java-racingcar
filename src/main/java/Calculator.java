import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.*;

public class Calculator {

    static int splitAndSum(String inputData) {
        if (checkIfEmpty(inputData)) {
            return 0;
        }

        List<String> parsedData = splitText(inputData);

        String delimiter = parsedData.get(0);
        String realText = parsedData.get(1);

        return sumAll(delimiter, realText);
    }

    private static boolean checkIfEmpty(String text) {
        return  text == null || text.isEmpty();
    }

    private static List<String> splitText (String inputData){
        String delimiter, realText;

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(inputData);
        if (m.find()) {
            delimiter = m.group(1);
            realText = m.group(2);
        } else {
            delimiter = ",|:";
            realText = inputData;
        }

        return Arrays.asList(delimiter, realText);
    }

    private static int sumAll (String delimiter, String text) {
        return convertStringArrayToIntArray(text.split(delimiter)).stream().mapToInt(Integer::intValue).sum();
    }

    private static List<Integer> convertStringArrayToIntArray(String[] inputString) {
        List<Integer> output = new ArrayList<>();
        for (String el : inputString) {
            int number = Integer.parseInt(el);
            if (number < 0) {
                throw new RuntimeException();
            }
            output.add(number);
        }

        return output;
    }

}
