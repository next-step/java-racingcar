package java_racingcar;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        int carNumber = InputView.carNumber();
        int racingTime = InputView.racingTime();

        Race race = new Race();
        List<Car> cars = race.readyForRacingCar(carNumber);

        ResultView.printEmptyLine();
        ResultView.printRaceResult();

        for (int i = 0; i < racingTime; i++) {
            race.doRacing(cars);
            ResultView.printEmptyLine();
        }
    }
}
