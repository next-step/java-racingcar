package carracing;

import carracing.car.Car;
import carracing.car.Position;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CarsMoveStatusHistory {
    /**
     * 외부 List : 자동차 경주(CarRacing)의 moveTryCount 갯수만큼 생성되어야 한다.
     * 내부 Map : 자동차 경주(CarRacing)의 cars 갯수만큼 생성되어야 한다.
     */
    private final List<Map<Car, Position>> carsMoveStatusHistory;

    public CarsMoveStatusHistory() {
        this.carsMoveStatusHistory = new ArrayList<>();
    }

    public void save(List<Car> cars) {
        Map<Car, Position> carsMoveStatus = new LinkedHashMap<>();
        for (Car car : cars) {
            carsMoveStatus.put(car, car.getPosition());
        }
        this.carsMoveStatusHistory.add(carsMoveStatus);
    }

    public List<Map<Car, Position>> getCarsMoveStatusHistory() {
        return this.carsMoveStatusHistory;
    }

    public Map<Car, Position> getCarsMoveStatusHistoryByMoveTryCount(int moveTryCount) {
        return this.carsMoveStatusHistory.get(moveTryCount);
    }
}
