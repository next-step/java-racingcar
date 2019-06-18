package racinggame;

import java.util.ArrayList;
import java.util.List;

public class GameResult {
    private final List<Integer> gameResult;

    public GameResult(CarLists carLists) {
        List<Integer> carPositionList = new ArrayList<>();
        for (Car car : carLists.getCarList()) {
            carPositionList.add(car.getPosition());
        }
        this.gameResult = carPositionList;
    }

    public List<Integer> getGameResult() {
        return this.gameResult;
    }
}
