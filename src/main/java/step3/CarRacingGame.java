package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarRacingGame {
    private Random random = new Random();
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
            displayRacingState(index);
        }
    }

    private void doRacing() {
        this.carEntryList
                .forEach(vo -> vo.move(random.nextInt(10)));
    }

    private void displayRacingState(int index) {
        System.out.println((index + 1) + "번째 게임 결과");
        this.carEntryList
                .forEach(car -> System.out.println(car.getPositionString()));
        System.out.println("");
    }

    private void readyToCarEntry() {
        this.carEntryList = new ArrayList<>();
        for (int index = 0; index < numberOfCar; index++) {
            this.carEntryList.add(new Car(index));
        }
    }

}
