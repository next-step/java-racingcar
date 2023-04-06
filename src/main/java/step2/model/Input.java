package step2.model;

import java.util.List;

public class Input {
    private final String inputSnapshot;
    private final List<String> inputList;

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
