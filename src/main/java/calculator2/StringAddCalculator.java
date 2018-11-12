package calculator2;

import spark.utils.StringUtils;

import static calculator2.StringSplitor.split;


public class StringAddCalculator {

    public int add(String text) {
        if (isBlank(text))
            return 0;

        StringNumber numbers = new StringNumber(split(text));

        return numbers.sum();
    }

    private boolean isBlank(String text) {
        return StringUtils.isEmpty(text);
    }

}
