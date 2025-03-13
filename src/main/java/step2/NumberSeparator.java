package step2;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import utils.StringUtils;

public class NumberSeparator {

    private static final String DEFAULT_DELIMITER = "[,:]";
    private static final String DELIMITER_FIND_REGEX = "//(.)\n(.*)";

    public List<Integer> separate(String input) {
        if (StringUtils.isEmpty(input)) {
            return List.of(0);
        }
        if (StringUtils.isNumeric(input)) {
            return List.of(Integer.parseInt(input));
        }
        Pattern pattern = Pattern.compile(DELIMITER_FIND_REGEX);
        Matcher matcher = pattern.matcher(input);

        String[] values;
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            values = matcher.group(2).split(customDelimiter);
        } else {
            values = input.split(DEFAULT_DELIMITER);
        }
        return convertStringArrayToIntegerList(values);
    }

    private List<Integer> convertStringArrayToIntegerList(String[] values) {
        List<Integer> members = new ArrayList<>();
        for (String value : values) {
            members.add(parseAndCheck(value));
        }
        return members;
    }

    private Integer parseAndCheck(String input) {
        int value;
        try {
            value = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자가 아닌 값이 입력되었습니다.");
        }
        if (value < 0) {
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        }
        return value;
    }
}
