package racing.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final List<Car> carList;

    public RacingGame() {
        carList = new ArrayList<>();
    }

    public void startGame() {
        List<String> nameList = UserInput.getCarNames();
        int tryNumber = UserInput.getTryNumber();
    }
}
