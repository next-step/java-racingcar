package calculator;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Splitter {
    Queue<String> tokens;

    public Splitter(String operation) {
        checkOperation(operation);

        tokens = new ArrayDeque<>(Arrays.asList(operation.split(" ")));
    }

    private void checkOperation(String operation) {
        if (operation == null || operation.isEmpty()) {
            throw new IllegalArgumentException("Operation is empty");
        }
    }

    public Queue<String> getTokens() {
        return tokens;
    }
}
