package camp.nextstep.racingcar;

import camp.nextstep.racingcar.domain.*;
import camp.nextstep.racingcar.interfaces.InputView;
import camp.nextstep.racingcar.interfaces.ResultView;

import java.util.List;

public class CarRacingApplication {

    public static void main(String[] args) {
        new CarRacingApplication().run(args);
    }

    public void run(String[] args) {
        RacingCarGameInputData inputData = InputView.getRacingCarGameInputData();
        RacingCarGame racingCarGame = new RacingCarGame(
                inputData.getRounds(),
                CarFactory.of(inputData.getCountOfCar()),
                new RandomMoveCondition(new DefaultRandomGenerator())
        );
        List<RacingCarGameRecord> record = racingCarGame.start();
        ResultView.print(record);
    }

}
