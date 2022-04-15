package racingCar.view;

import racingCar.CarStadium;

import java.util.Scanner;

public class InputViewRacingCar {

    private static final Scanner scanner = new Scanner(System.in);

    private InputViewRacingCar() {
    };

    public static void inputRacingData() {
        inputPlayCarNum();
        inputRounds();
    }

    private static void inputPlayCarNum() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");

        String inputCars = inputString();

        CarStadium.initCars(inputCars);
    }

    private static void inputRounds() {
        System.out.println("시도할 회수는 몇 회 인가요?");

        int rounds = inputInt();

        CarStadium.initRounds(rounds);
    }

    private static String inputString() {
        return scanner.nextLine();
    }

    private static int inputInt() {
        return scanner.nextInt();
    }
}
