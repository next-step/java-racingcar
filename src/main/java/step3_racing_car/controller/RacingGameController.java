package step3_racing_car.controller;

import step3_racing_car.view.InputView;
import step3_racing_car.view.OutputView;
import step3_racing_car.domain.RacingCar;
import step3_racing_car.domain.RacingCars;
import step3_racing_car.domain.Winners;
import step3_racing_car.strategy.MovingStrategy;
import step3_racing_car.strategy.RandomStrategy;

import java.util.ArrayList;
import java.util.List;

public class RacingGameController {
    public void playGame() {
        // 게임 세팅
        List<String> participantCarNames = InputView.scanCarNames();
        int roundCount = InputView.scanRoundCount();

        // 게임 룰 세팅 후 라운드 진행 - Random 전략으로 이동한다.
        List<RacingCar> racingCarList = new ArrayList<>();
        for (String name: participantCarNames) {
            racingCarList.add(new RacingCar(name));
        }

        RacingCars racingCars = new RacingCars(racingCarList);
        MovingStrategy movingStrategy = new RandomStrategy();

        // 게임 진행
        for (int i = 0; i < roundCount; i++) {
            racingCars.movePosition(movingStrategy);
            OutputView.printRoundResult(racingCars);
        }

        // 게임 종료후 우승자 출력
        // todo: [질문] 여기서 winners로 게임 승자를 출력해야하는데,
        //  출력의 toString을 RacingCars 일급컬렉션에 주고싶어 findWinners를 RacingCars로 wrapping해 리턴하게 됨.
        Winners winners = new Winners(racingCars);
        List<String> gameWinners = winners.findWinners();
        OutputView.printGameWinner(gameWinners);
    }
}
