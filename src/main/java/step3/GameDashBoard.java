package step3;

import java.util.List;

public class GameDashBoard {
    private List<Car> cars;

    public GameDashBoard(List<Car> cars) {
        this.cars = cars;
    }

    public void show() {
        for (Car car : cars) {
            for (int i = 0; i < car.getStraightCount(); i++) {
                System.out.print("-");
            }

            System.out.println("");
        }

        System.out.println("");
    }
}
