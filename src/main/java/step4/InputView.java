package step4;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {

    private int moveCount;
    private List<Car> cars;
    private static final String DILIMITER_COMMA = ",";
    private static final String DEFAULT_RACING_RESULT = "";

    public InputView() {
    }

    public InputView(String carNames, int moveCount) {
        validateInput(carNames);
        this.moveCount = moveCount;
        this.cars = createUsers(splitCarName(carNames));
    }

    public void validateInput(String carNames) {
        if (carNames == null || "".equals(carNames.trim())) {
            throw new IllegalArgumentException();
        }
    }

    public String[] splitCarName(String carNames) {
        return carNames.split(DILIMITER_COMMA);
    }

    public List<Car> createUsers(String[] splitCarName) {
        return Arrays.stream(splitCarName)
                     .map(carName -> new Car(carName, DEFAULT_RACING_RESULT))
                     .collect(toList());
    }

    public int getMoveCount() {
        return moveCount;
    }

    public List<Car> getCars() {
        return cars;
    }

}
