package calculator;

import java.util.ArrayList;
import java.util.List;

public class Extractor {

    public List<String> extractOperators(String[] strings) {
        List<String> results = new ArrayList<>();
        for (int i = 1; i < strings.length; i = i + 2) {
            results.add(strings[i]);
        }
        return results;
    }

    public List<Integer> extractNumbers(String[] strings) {
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < strings.length; i = i + 2) {
            results.add(Integer.valueOf(strings[i]));
        }
        return results;
    }
}
