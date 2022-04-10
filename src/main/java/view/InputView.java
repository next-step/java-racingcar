package view;

import racingcar.Cars;
import racingcar.Race;
import racingcar.RaceCondition;

import java.util.Scanner;

public class InputView {
    public static void main(String[] args) throws InterruptedException {
        Scanner inputNumber = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        int carCount = inputNumber.nextInt();
        System.out.println("시도할 횟수는 몇 회 인가요?");
        int tryCount = inputNumber.nextInt();

        Cars cars = Cars.builder()
                .carCount(carCount)
                .raceCondition(new RaceCondition())
                .build();
        new Race(new ResultView()).start(cars, tryCount);
    }
}
