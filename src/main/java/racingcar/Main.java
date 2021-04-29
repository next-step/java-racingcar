package racingcar;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RacingCar racingCar = new RacingCar();
        NonTestRacingCar nonTestRacingCar = new NonTestRacingCar();

        Scanner scanner = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carName = scanner.nextLine();

        racingCar.nameCheck(carName);

    }
}
