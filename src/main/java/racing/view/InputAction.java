package racing.view;

import java.util.Arrays;
import java.util.Optional;

public enum InputAction {
    MOVE("Y"), SKIP("N"), QUIT("Q");

    private final String keyword;

    InputAction(String keyword) {
        this.keyword = keyword;
    }

    public static Optional<InputAction> of(String input) {
        return Arrays.stream(values())
                .filter(
                        a -> a.keyword.equals(input)
                ).findFirst();
    }
}
