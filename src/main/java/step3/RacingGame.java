package step3;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private List<Car> cars = new ArrayList<>();

    public void readyCar(int CarCount) {
        for (int i = 0; i < CarCount; i++) {
            cars.add(new Car());
        }
    }

    public void playGame(int tryCount) {
        System.out.println("실행결과");
        for (int i = 0; i < tryCount; i++) {
            moveCars();
        }
    }

    private void moveCars() {
        for (Car car : cars) {
            car.move(RandomNumberGenerator.randomNumber());
            ResultView.gameResultView(car.getLocation());
        }
        System.out.println("");
    }

}
