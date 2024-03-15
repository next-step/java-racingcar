package racing_winner;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputLayer {

    private static final int MAX_LENGTH = 5;
    private final InputConsole inputConsole;

    public InputLayer(InputConsole inputConsole) {
        this.inputConsole = inputConsole;
    }

    public List<String> getCarNames() {
        return splitName(inputConsole.readCarNames()).stream().filter(this::validateLength).collect(Collectors.toUnmodifiableList());
    }

    private boolean validateLength(String text) {
        if (text.length() <= MAX_LENGTH)
            return true;
        throw new IllegalArgumentException("Car 의 이름은 5자를 초과할수 없습니다.");
    }

    private List<String> splitName(String text) {
        return List.of(text.split(","));
    }

    public int getGameCount() {
        return Integer.parseInt(inputConsole.readGameCount());
    }


}
