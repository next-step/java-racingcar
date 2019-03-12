package racingcar;

import java.awt.print.Pageable;

public class MainApplication {
    public static void main(String[] args) {
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carNumber = InputView.inputInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        int inputTimes = InputView.inputInt();

        System.out.println("실행 결과");
        RacingGame racingGame = new RacingGame(carNumber);
        for(int i = 0; i < inputTimes; i++) {
            ResultView.viewCars(racingGame.move());
        }
    }
}
