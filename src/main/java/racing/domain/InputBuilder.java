package racing.domain;

import java.util.Arrays;
import java.util.List;

public class InputBuilder {
    private static int  criteria = 5;

    private List<String> nameList ;

    public List<String> getNameList() {
        return nameList;
    }

    public InputBuilder(String input) {
        List<String> nameList = convertInput(input);
        this.nameList = nameList;
    }

    private List<String> convertInput(String input) {
        String[] name = input.split(",");
        List<String> nameList = Arrays.asList(name);
        return nameList;
    }
}
