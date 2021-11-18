package racingcar;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        InputView inputView = new InputView(new Scanner(System.in));
        int carCount = inputView.next("자동차 대수는 몇 대 인가요?");
        int racingCount = inputView.next("시도할 횟수는 몇 회 인가요?");

        RacingCar racingCar = RacingCar.create(carCount, racingCount);
        racingCar.start();

        inputView.close();
    }
}
