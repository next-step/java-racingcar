package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;

public class Application {
    public void start() {
    }

    public ArrayDeque<String> userInput() {
        ArrayDeque<String> dequeInput = null;
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in))) {
            String input = br.readLine();
            dequeInput = stringToDeque(input);
            return dequeInput;
        } catch (IOException e) {
            System.out.println("Input Array");
            return dequeInput;
        }
    }

    public ArrayDeque<String> stringToDeque(String input) {
        List<String> stringList = Arrays.asList(input.split(" "));
        return new ArrayDeque<>(stringList);
    }
}
