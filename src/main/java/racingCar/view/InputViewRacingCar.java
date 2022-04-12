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
        System.out.println("자동차 대수는 몇 대 인가요?");

        int nums = input();

        CarStadium.initCars(nums);
    }

    private static void inputRounds() {
        System.out.println("시도할 회수는 몇 회 인가요?");

        int rounds = input();

        CarStadium.initRounds(rounds);
    }

    private static int input() {
        return scanner.nextInt();
    }
}
