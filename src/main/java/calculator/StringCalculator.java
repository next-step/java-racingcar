package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {

    public static final String BLANK = " ";

    public List<String> splitText (String text) {
        String[] textArr = text.split(BLANK);
        List<String> values = new ArrayList<>();
        Arrays.stream(textArr)
                .map(values::add)
                .collect(Collectors.toList());
        return values;
    }

}



