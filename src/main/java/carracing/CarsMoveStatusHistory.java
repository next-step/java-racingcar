package carracing;

import java.util.ArrayList;
import java.util.List;

public class CarsMoveStatusHistory {
    /**
     * 외부 List : 자동차 경주(CarRacing)의 moveTryCount 갯수만큼 생성되어야 한다.
     * 내부 List : 자동차 경주(CarRacing)의 cars 갯수만큼 생성되어야 한다.
     */
    private final List<List<Integer>> carsMoveStatusHistory;

    public CarsMoveStatusHistory() {
        this.carsMoveStatusHistory = new ArrayList<>();
    }

    public void save(List<Car> cars) {
        ArrayList<Integer> carsMoveStatusOfEachMoveTryCount = new ArrayList<>();

        for (Car car : cars) {
            carsMoveStatusOfEachMoveTryCount.add(car.getMoveStatus());
        }
        this.carsMoveStatusHistory.add(carsMoveStatusOfEachMoveTryCount);
    }

    public List<List<Integer>> getCarsMoveStatusHistory() {
        return this.carsMoveStatusHistory;
    }

    public List<Integer> getCarsMoveStatusHistoryByMoveTryCount(int moveTryCount) {
        return this.carsMoveStatusHistory.get(moveTryCount);
    }

    public int getCarMoveStatusHistory(int tryCount, int carIndex) {
        return this.carsMoveStatusHistory.get(tryCount).get(carIndex);
    }
}
