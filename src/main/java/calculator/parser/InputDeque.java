package calculator.parser;

import java.util.*;

public class InputDeque {
    Deque<String> inputItems = new ArrayDeque<>();

    public InputDeque(String[] splitInput) {
        inputItems.addAll(Arrays.asList(splitInput));
    }

    public String popInputItem() {
        return inputItems.pop();
    }

}
