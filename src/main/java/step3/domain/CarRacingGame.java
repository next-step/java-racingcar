package step3.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarRacingGame {

    private static final String CAR_NUMBER_FORMAT = "car_number_%d";

    private final int carCount;
    private final int tryCount;
    private List<Car> cars = new ArrayList<>();


    public CarRacingGame(int carCount, int tryCount) {
        this.carCount = carCount;
        this.tryCount = tryCount;
        prepareCars();
    }


    private void prepareCars() {
        for (int i = 0; i < carCount; i++) {
            String carNumber = String.format(CAR_NUMBER_FORMAT, i);
            cars.add(new Car(carNumber));
        }
    }


    private List<String> getCarNumbers() {
        List<String> carNumbers = cars.stream()
            .map(car -> car.carNumber)
            .collect(Collectors.toList());
        return carNumbers;
    }

    @Override
    public String toString() {
        return String
            .format("(자동차 게임)\n 자동차수: %d \n 시도회수: %d \n 생성된 차량 번호 리스트: %s",
                this.carCount, this.tryCount, getCarNumbers());
    }
}
