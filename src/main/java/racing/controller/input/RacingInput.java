package racing.controller.input;

import racing.exception.IllegalCountException;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RacingInput {

    private final Scanner scanner;

    public RacingInput(InputStream inputStream) {
        this.scanner = new Scanner(inputStream);
    }

    public List<String> inputName() {
        return Arrays.stream(this.scanner.next().split(","))
                .collect(Collectors.toList());
    }

    public int inputCount() {
        try {
            return Integer.parseInt(this.scanner.next());
        } catch (NumberFormatException e) {
            throw new IllegalCountException();
        }
    }
}
