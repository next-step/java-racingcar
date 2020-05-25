package racecar;

import racecar.domain.Car;
import racecar.domain.RacingGame;
import racecar.view.InputView;

import java.util.List;

public class gameController {
    public static void main(String[] args) {
        //입력
        String[] carName = InputView.askCarNames();
        int repeatCount = InputView.askRepeatCount();

        //게임 준비
        RacingGame racingGame = new RacingGame();
        List<Car> carList = racingGame.ready(carName);

        //게임 실행
        for (int i = 0; i < repeatCount; i++) {
            racingGame.start(carList);
            System.out.println();
        }

        //우승자 발표
        racingGame.announceWinner(carList);

    }
}
