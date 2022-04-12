package racingCar.view;

import racingCar.Car;
import racingCar.CarStadium;

import java.util.LinkedList;

public class ResultViewRacingCar {

    public void resultViewRacing() {
        System.out.println();
        System.out.println("실행결과");

        int rounds = CarStadium.getRounds();

        for (int i = 0; i < rounds; ++i) {
            resultViewCarMove();
        }
    }

    private void resultViewCarMove() {
        LinkedList<Car> list = CarStadium.getCars();

        for (int i = 0; i < list.size(); ++i) {
            resultViewCarMove(list.get(i));
        }
        System.out.println();
    }

    private void resultViewCarMove(Car car) {
        car.move(CarStadium.extractRandomNumber());
        System.out.println(car.getDistance());
    }
}
