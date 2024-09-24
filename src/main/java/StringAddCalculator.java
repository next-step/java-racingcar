import java.util.ArrayList;
import java.util.List;

public class StringAddCalculator {
    public int splitAndSum(String input) {
        if (input == null || input.equals("")) {
            return 0;
        }

        if (input.length() == 1) {
            return Integer.parseInt(input);
        }

        String[] strings = input.split(",|:");
        List<Integer> ints = convertStringArrayToIntArray(strings);
        int result = addCalculator(ints);
        return result;
    }

    private int addCalculator(List<Integer> input) {
        int sum = 0;

        for (int value : input) {
            sum += value;
        }

        return sum;
    }

    private List<Integer> convertStringArrayToIntArray(String[] input) {
        List<Integer> result = new ArrayList<>();

        for (String string : input) {
            result.add(Integer.parseInt(string));
        }

        return result;
    }
}
