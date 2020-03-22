package stringCalculator;


import java.util.ArrayList;
import java.util.Arrays;

public class InputStringHandler {

    private String inputString;
    private ArrayList<String> inputStringList;

    public InputStringHandler() {
    }

    public ArrayList<String> work(String input) {
        this.inputString = input;
        emptyInputException();
        split();

        return inputStringList;
    }

    private void split() {
        inputStringList = new ArrayList<>(Arrays.asList(inputString.split(" ")));
    }

    private void emptyInputException() {
        if(inputString == null || inputString.trim().isEmpty()) throw new IllegalArgumentException();
    }

}
