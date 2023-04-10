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

    private static final Pattern PATTERN = Pattern.compile("//(.)\n(.*)");

    private static boolean checkIfEmpty(String text) {
        return  text == null || text.isEmpty();
    }

    private static List<String> splitText (String inputData){
        String delimiter, realText;

        final int DELIMITER_INDEX = 1;
        final int TEXT_INDEX = 2;

        final Matcher m = PATTERN.matcher(inputData);

        if (m.find()) {
            delimiter = m.group(DELIMITER_INDEX);
            realText = m.group(TEXT_INDEX);
        } else {
            delimiter = ",|:";
            realText = inputData;
        }

        return Arrays.asList(realText.split(delimiter));
    }

    private static int sumAll (List<String> strings) {
        return convertStringsToNumbers(strings).stream().mapToInt(Integer::intValue).sum();
    }

    private static List<Integer> convertStringsToNumbers(List<String> inputString) {
        List<Integer> output = new ArrayList<>();
        for (String numberStr : inputString) {
            int number = Integer.parseInt(numberStr);
            if (number < 0) {
                throw new IllegalArgumentException("입력값은 양수로 입력해야 합니다.");
            }
            output.add(number);
        }

        return output;
    }

}


