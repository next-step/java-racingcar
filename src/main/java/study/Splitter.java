package study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Splitter {

    private Delimiter delimiter;
    private String numberText;

    public List<String> split(String text, String delimiter) {
        String[] stringArray = text.split(delimiter);
        return Arrays.stream(stringArray).collect(Collectors.toList());
    }
}
