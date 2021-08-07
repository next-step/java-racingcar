/*
 * edu.nextstep.racingcarwinner.RacingMain.java
 * 0.1 2021.08.07 18:24
 * 해당 클래스의 경우 TDD, CleanCode with Java 수업의 RacingCar step4에 해당됩니다.
 */

package edu.nextstep.racingcarwinner;

import edu.nextstep.racingcarwinner.domain.Car;
import edu.nextstep.racingcarwinner.domain.RacingCars;
import edu.nextstep.racingcarwinner.domain.RacingGame;
import edu.nextstep.racingcarwinner.strategy.RandomStrategy;
import edu.nextstep.racingcarwinner.view.InputView;
import edu.nextstep.racingcarwinner.view.OutputView;

import java.util.List;

public class RacingMain {

    public static void main(String[] args) {
        // Input, OutPut view 생성
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        // 입력값 입력
        String carName = inputView.inputCarName();
        int roundNum = inputView.inputRoundNum();

        // 입력값에 맞는 자동차 생성 및 RacingGame 참여
        RacingGame racingGame = new RacingGame();
        String[] carNameArr = carName.split(",");
        List<Car> carList = RacingCars.makeCarList(carNameArr);
        RacingCars racingCars = RacingCars.makeRacingCars(carList);
        racingGame.joinGame(racingCars);

        // RacingGame 진행
        outputView.printStartSign();
        for (int i = 0; i < roundNum; i++) {
            racingGame.playOneRound(new RandomStrategy());
            outputView.printOneRound(racingCars);
        }

        // winner 출력
        List<Car> winners = racingGame.getWinner();
        outputView.printWinner(winners);

    }
}
