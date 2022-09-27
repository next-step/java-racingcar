package step3;

import java.util.ArrayList;
import java.util.List;

public class CarRacingGame {
    private final Integer tryCount;
    private final List<Car> carEntryList = new ArrayList<>();

    CarRacingGame(int numberOfCar, int tryCount) {
        this.tryCount = tryCount;
        for (int index = 0; index < numberOfCar; index++) {
            this.carEntryList.add(new Car(index));
        }
    }

    public List<Car> getCarEntryList() {
        return carEntryList;
    }

    // 게임 시작
    public void doGame() {
        for (int index = 0; index < this.tryCount; index++) {
            doRacing();
        }
    }

    private void doRacing() {
        this.carEntryList
                .forEach(Car::run);
    }

}
