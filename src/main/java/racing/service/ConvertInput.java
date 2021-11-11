package racing.service;

import java.util.Arrays;
import java.util.List;

public class ConvertInput {
    public List<String> convertInput(String input) {
        String[] name = input.split(",");
        List<String> nameList = Arrays.asList(name);
        return nameList;
    }
}
