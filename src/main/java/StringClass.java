import java.util.Arrays;

public class StringClass {

    public int[] split(String input, String delimiter) {

        String[] res = input.split(delimiter);

        return Arrays.stream(res).mapToInt(Integer::parseInt).toArray();
    }
    public String substring(String input) {

        int lengthOfString = input.length();
        String onlyDigits = input.substring(1, lengthOfString-1);

        return onlyDigits;
    }
}
