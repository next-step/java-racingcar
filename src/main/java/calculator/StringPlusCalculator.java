package calculator;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringPlusCalculator {
    private final static String DEFAULT_DELIMITER = ",|:";

    public int add(String originInputString) {
        if(StringUtils.isBlank(originInputString)) {
            return 0;
        }

        String[] stringValues = splitStringByDelimiter(originInputString);

        return getSumNumber(convertingStrigToIntArray(stringValues));
    }

    public String[] splitStringByDelimiter(String originString) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(originString);

        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }

        return originString.split(DEFAULT_DELIMITER);
    }

    public int[] convertingStrigToIntArray(String[] stringValues) {
        int[] intValues = new int[stringValues.length];
        int i=0;

        for(String strValue : stringValues) {
            intValues[i++] = validateIntValueIsNegative(Integer.parseInt(strValue));

        }
        return intValues;
    }

    public int validateIntValueIsNegative(int intValue) {
        if (intValue < 0) {
            throw new RuntimeException();
        }
        return intValue;
    }

    public int getSumNumber(int[] intValues) {
        int sum = 0;

        for(int intValue : intValues) {
            sum += intValue;
        }

        return sum;
    }
}
