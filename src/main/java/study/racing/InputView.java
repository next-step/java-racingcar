package study.racing;

import study.validation.InputValidation;

import java.util.Scanner;

public class InputView {

    public Car input() {
        Scanner scanner = new Scanner(System.in);
        Car car = new Car();

        while (true) {

            System.out.println(RacingMessage.CAR_COUNT.msg());
            String carCount = scanner.nextLine();

            System.out.println(RacingMessage.TRY_COUNT.msg());
            String tryCount = scanner.nextLine();

            boolean isInputMatchForCar = InputValidation.racingInputValidation(carCount);
            boolean isInputMatchForTry = InputValidation.racingInputValidation(tryCount);

            if(isInputMatchForCar && isInputMatchForTry) {
                car.setCarCount(Integer.parseInt(carCount));
                car.setTryCount(Integer.parseInt(tryCount));
                break;
            }
        }
        return car;
    }
}
