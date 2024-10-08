package racing.view;

import racing.car.Car;
import racing.car.Cars;

public class ResultView {

    public void racingPrint(Cars cars) {
        for (Car car : cars.getItems()) {
            System.out.print(car.getName() + ":");
            movePrint(car);
        }
        System.out.println();
    }

    private void movePrint(Car car) {
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void endCycle() {
        System.out.println();
    }

    public void winnerPrint(Cars winner) {
        System.out.println("우승자 발표!");
        for (Car car : winner.getItems()) {
            System.out.println(car.getName());
        }
    }
}
