import java.util.ArrayList;

public class StringCalculator {

    private final String DEFAULT_DELEMITER = "[,:]";
    private final String CUSTOM_DELEMITER_START = "//";
    private final String CUSTOM_DELEMITER_END = "\n";

    void StringCalculator() {

    };

    public int calculate(String input) {
        if (input == null || input == "") {
            return 0;
        }

        String delemiter = DEFAULT_DELEMITER;
        String customDelemiter = findCustomDelemiter(input);

        if (customDelemiter != "") {
            delemiter += "|" + customDelemiter;
            input = removeCustomDelemiter(input);
        }

        String[] split = input.split(delemiter);

        int result = 0;
        for (int i=0; i < split.length; i++) {
            int tmp = Integer.parseInt(split[i]);

            validatePositive(tmp);
            result += tmp;
        }

        return result;
    }

    private String findCustomDelemiter(String input) {
        String result = "";

        if (input.startsWith(CUSTOM_DELEMITER_START)) {
            int endIndex = input.indexOf(CUSTOM_DELEMITER_END);

            result = input.substring(2, endIndex);
        }

        return result;
    }

    private String removeCustomDelemiter(String target) {
        String result = target;

        if (target.startsWith(CUSTOM_DELEMITER_START)) {
            int endIndex = target.indexOf(CUSTOM_DELEMITER_END);

            result = target.substring(endIndex + 1);
        }

        return result;
    }

    private void validatePositive(int number) {
        if (number < 0) {
            throw new RuntimeException("음수가 포함되어 있음");
        }
    }
}
