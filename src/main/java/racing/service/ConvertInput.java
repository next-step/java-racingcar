package racing.service;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ConvertInput {

    public List<String> convertInput(String input) {
        String[] name = input.split(",");
        List<String> nameList = Arrays.asList(name);
        return nameList;
    }

    public boolean nameLengthCheck(List<String> nameList) {
        Integer criteria = 5;
        return nameList.stream().anyMatch(i -> i.length() > criteria);
    }
}
