package racingCar.ui;

import racingCar.domain.RacingGame;
import racingCar.dto.RacingGameInfo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static RacingGameInfo settingRacingGame() {
        String[] carNames = getCarNames();
        int time = getTime();
        return new RacingGameInfo(carNames, time);
    }

    private static String[] getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.next().split(",");
    }

    private static int getTime() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        try{
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new InputMismatchException("숫자가 아닙니다.");
        }
    }
}
