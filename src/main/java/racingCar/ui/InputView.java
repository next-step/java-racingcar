package racingCar.ui;

import racingCar.application.RacingGame;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public RacingGame settingRacingGame() {
        String[] carNames = getCarNames();
        int time = getTime();
        return new RacingGame(carNames, time);
    }

    private String[] getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.next().split(",");
    }

    private int getTime() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        try{
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new InputMismatchException("숫자가 아닙니다.");
        }
    }
}
