package racingcar.presentation;

import java.util.Scanner;

public class InputView {

    private int countOfCars;
    private int countOfMovesAttemps;

    public void inputCountOfCars() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        countOfCars = input();
    }

    public void inputCountOfMovesAttemps() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        countOfMovesAttemps = input();
    }

    private int input() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public int getCountOfCars() {
        return this.countOfCars;
    }

    public int getCountOfMovesAttemps() {
        return this.countOfMovesAttemps;
    }
}
