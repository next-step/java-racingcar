package racingCar.view;

import racingCar.CarStadium;

import java.util.Scanner;

public class InputViewRacingCar {

    public void inputRacingData() {
        inputPlayCarNum();
        inputRounds();
    }

    private void inputPlayCarNum() {
        System.out.println("자동차 대수는 몇 대 인가요?");

        int nums = input();

        CarStadium.initCars(nums);
    }

    private void inputRounds() {
        System.out.println("시도할 회수는 몇 회 인가요?");

        int rounds = input();

        CarStadium.initRounds(rounds);
    }

    private int input() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
