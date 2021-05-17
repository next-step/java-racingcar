package calculator;

import java.util.ArrayList;
import java.util.List;

public class Extractor {

    public List<String> extract(String[] strings) {
        List<String> results = new ArrayList<>();
        for (int i = 1; i < strings.length; i = i + 2) {
            results.add(strings[i]);
        }
        return results;
    }
}
