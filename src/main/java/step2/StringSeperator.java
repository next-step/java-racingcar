package step2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSeperator {
    private final Pattern pattern = Pattern.compile("//(.)\n(.*)");
    public List<Integer> seperate(String input) {
        List<Integer> numbers = new ArrayList<>();

        if (isBlank(input)) {
            numbers.add(0);
            return numbers;
        }

        List<String> delimiters = findDelimiter(input);
        String numberGroups = findNumberGroups(input);

        List<String> data = split(numberGroups, delimiters);
        return convert(data);
    }

    private List<String> findDelimiter(String input) {
        Set<String> delimiters = new HashSet<>();
        delimiters.add(",");
        delimiters.add(":");

        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            delimiters.add(matcher.group(1));
        }
        return new ArrayList<>(delimiters);
    }

    private String findNumberGroups(String input) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            return matcher.group(2);
        }
        return input;
    }

    private List<String> split(String numberGroups, List<String> delimiters) {
        List<String> data = new ArrayList<>();
        String newData = numberGroups;
        for (String delimiter : delimiters) {
            newData = newData.replace(delimiter, ",");
        }
        return List.of(newData.split(","));
    }

    private List<Integer> convert(List<String> data) {
        return data.stream()
                .map(PositiveNumber::new)
                .map(PositiveNumber::getValue)
                .collect(Collectors.toList());
    }

    private boolean isBlank(String input) {
        return input == null || input.isEmpty();
    }
}