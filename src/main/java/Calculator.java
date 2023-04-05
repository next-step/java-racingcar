import java.util.Arrays;
import java.util.regex.*;

public class Calculator {

    static int splitAndSum(String inputData) {
        if (checkIfEmpty(inputData)) {
            return 0;
        }

        String delimiter, realText;

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(inputData);
        if (m.find()) {
            delimiter = m.group(1);
            realText = m.group(2);
        } else {
            delimiter = ",|:";
            realText = inputData;
        }

        return Arrays.stream(convertStringArrayToIntArray(realText.split(delimiter))).sum();
    }

    private static boolean checkIfEmpty(String text) {
        return  text == null || text.isEmpty();
    }

    private static int[] convertStringArrayToIntArray(String[] inputString) {
        int[] output = new int[inputString.length];
        for (int ix=0; ix < inputString.length; ix++) {
            output[ix] = Integer.parseInt(inputString[ix]);
            if (output[ix] < 0) {
                throw new RuntimeException();
            }
        }

        return output;
    }

}
