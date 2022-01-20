package racing.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final List<Car> carList;

    public RacingGame() {
        carList = new ArrayList<>();
    }

    public void startGame() {
        List<String> nameList = UserInput.getCarNames();
        int tryNumber = UserInput.getTryNumber();
        for (String name : nameList) {
            carList.add(new Car(name));
        }

        startRacing(tryNumber);
    }

    private void startRacing(int tryNumber) {
        System.out.println("\n실행 결과");
        for (int i = 0; i < tryNumber; i++) {
            driveCars();
            System.out.println();
        }
    }

    private void driveCars() {
        for (Car car : carList) {
            car.drive();
        }
    }
}
