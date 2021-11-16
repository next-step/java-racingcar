package racing.domain;

import java.util.Arrays;
import java.util.List;

public class GetNameList {

    private List<String> nameList ;

    public GetNameList(String input) {
        this.nameList = convertInput(input);
    }

    public List<String> getNameList() {
        return nameList;
    }

    private List<String> convertInput(String input) {
        return Arrays.asList(input.split(","));
    }
}
