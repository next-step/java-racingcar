package step4.domain;

import step4.dto.Data;
import step4.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> carList;

    public Cars() {
        carList = new ArrayList<>();
    }

    public Cars(List<Car> list) {
        carList = list;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void createList(Data data) {
        String[] names = StringUtil.splite(data.getNames(), ",");
        for (String name : names) {
            carList.add(new Car(name));
        }
    }

    public List<Car> findWinner() {
        List<Car> winners = new ArrayList<>();
        Position maxPosition = getMaxPostion(carList);
        for (Car car : carList) {
            setWinner(car, maxPosition, winners);
        }
        return winners;
    }

    private Position getMaxPostion(List<Car> carList) {
        Position maxPosition = new Position();
        for (Car car : carList) {
            maxPosition = car.getMaxPosition(maxPosition);
        }
        return maxPosition;
    }

    private void setWinner(Car car, Position maxPosition, List<Car> winners) {
        if (maxPosition.isZero()) {
            return;
        }
        if (car.isWinner(maxPosition)) {
            winners.add(car);
        }
    }

}
