import java.util.ArrayList;
import java.util.List;

public class CarRacingExecutor {

    public List<Car> carList;

    private int remainMoveCount;

    public int getRemainMoveCount() {
        return remainMoveCount;
    }

    public boolean useRemainCount() {
        if (remainMoveCount <= 0) {
            return false;
        }
        remainMoveCount--;
        return true;
    }

    public CarRacingExecutor(int carCount, int moveCount) {
        carList = new ArrayList();
        remainMoveCount = moveCount;

        for (int i = 0; i < carCount; i++) {
            carList.add(new Car());
        }
    }

    public void proceedNextRound() {
        carList.forEach(Car::move);
    }
}
