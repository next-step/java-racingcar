package racinggame.ui;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserInput {
    private final int carCount;
    private final List<String> carNames;
    private final int tryCount;

    private static final String CAR_NAME_DELIMITER = ",";

    public UserInput(
            String inputCarNames,
            int tryCount
    ) {
        String[] carNameArray = inputCarNames.split(CAR_NAME_DELIMITER);

        this.carCount = carNameArray.length;
        this.carNames = new ArrayList<>(
                Arrays.asList(carNameArray)
        );
        this.tryCount = tryCount;
    }
}
