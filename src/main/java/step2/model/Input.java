package step2.model;

import java.util.ArrayList;
import java.util.List;

public class Input {
    private String inputSnapshot;
    private List<String> inputList = new ArrayList<>();

    public Input(String input, List<String> inputList) {
        this.inputSnapshot = input;
        this.inputList = inputList;
    }

    public List<String> getInputList() {
        return inputList;
    }

    public String getInput() {
        return inputSnapshot;
    }
}
