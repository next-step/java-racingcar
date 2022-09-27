package step3;

import java.util.ArrayList;
import java.util.List;

public class CarRacingGame {
    private Integer numberOfCar;
    private Integer tryCount;
    private List<Car> carEntryList;

    CarRacingGame(int numberOfCar, int tryCount) {
        this.numberOfCar = numberOfCar;
        this.tryCount = tryCount;
    }

    // 게임 시작
    public void doGame() {
        readyToCarEntry();
        for (int index = 0; index < this.tryCount; index++) {
            doRacing();
            // 각 게임 회차마다 현황 출력
            ResultView.displayRacingState(this.carEntryList);
        }
    }

    private void doRacing() {
        this.carEntryList
                .forEach(Car::run);
    }

    private void readyToCarEntry() {
        this.carEntryList = new ArrayList<>();
        for (int index = 0; index < numberOfCar; index++) {
            this.carEntryList.add(new Car(index));
        }
    }

}
