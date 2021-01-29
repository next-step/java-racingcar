package step3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private List<Car> cars;
    private CarMover carMover;

    public Cars(List<String> carNameList) {
        this.carMover = new CarMover();
        this.cars = new ArrayList<>();
        for (int i = 0; i < carNameList.size(); i++) {
            this.cars.add(new Car(carNameList.get(i)));
        }
    }

    public Cars(ArrayList<Car> cars) {
        this.carMover = new CarMover();
        this.cars = cars;
    }

    public List<Car> getWinners() {
        return CarWinnerDiscriminator.discriminate(this.cars);
    }

    public String playAndGetResult() {
        cars.forEach(car -> carMover.moveOrNot(car, NumberUtil.generateRandomIntZeroToTen()));
        StringBuilder stringBuilder = new StringBuilder();
        cars.forEach(car -> {
            stringBuilder.append(car.getWayResult());
            stringBuilder.append(System.lineSeparator());
        });
        return stringBuilder.toString();
    }
}

