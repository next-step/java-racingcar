package step2;

import step2.dto.StringAddCalculatorDto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SeparatorFinder {
    private static Pattern customSeparatorPattern = Pattern.compile("//(.)\n(.*)");
    private static final String[] defaultSeparators = {",", ":"};

    public StringAddCalculatorDto getStringAddCalculatorDto(String str) {
        String text = str;
        String customSeparator = null;

        Matcher m = customSeparatorPattern.matcher(str);
        if (m.find()) {
            customSeparator = m.group(1);
            text = m.group(2);
        }

        return new StringAddCalculatorDto(text, getRegex(customSeparator));
    }

    public String getRegex(String customSeparator) {
        ArrayList<String> separators = new ArrayList<>();

        Collections.addAll(separators, defaultSeparators);
        separators.add(customSeparator);

        return String.join("|", separators);
    }
}
