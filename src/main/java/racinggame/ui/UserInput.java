package racinggame.ui;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserInput {
    private final String carNames;
    private final int tryCount;

    public UserInput(
            String inputCarNames,
            int tryCount
    ) {
        this.carNames = inputCarNames;
        this.tryCount = tryCount;
    }

    public String getCarNames() {
        return carNames;
    }

    public int getTryCount() {
        return tryCount;
    }
}
