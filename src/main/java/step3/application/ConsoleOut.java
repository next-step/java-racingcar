package step3.application;

import step3.domain.Car;
import step3.domain.CarRace;
import step3.domain.NumberGenerator;

public class ConsoleOut {
    public void askCarsCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
    }

    public void askMoveCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
    }

    public void result(CarRace carRace, NumberGenerator numberGenerator) {
        carRace.cars().stream().map(car -> {
            Car moveCar = car.move(numberGenerator);
            String strState = "-".repeat(moveCar.state());
            System.out.println(strState);
        });
        System.out.println();

    }
}
