package racingGame;

import java.util.List;

public class ResultView {

    public void printRound(List<Car> carList) {
        for (Car car : carList) {
            printCar(car);
        }
        System.out.println();
    }

    private void printCar(Car car) {
        System.out.println(new String(new char[car.getCurrentPosition()])
            .replace("\0", "-"));
    }

}
