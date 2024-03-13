package racingcar;

import racingcar.controller.Race;
import racingcar.domain.MoveByRandomNumberStrategy;
import racingcar.domain.MoveStrategy;
import racingcar.dto.RaceResult;
import racingcar.view.Output;


public class RacingGameApplication {

    public static void main(String[] args) {

        Output output = new Output();

        int tryCount = 5;
        int carCount = 5;
        MoveStrategy moveStrategy = new MoveByRandomNumberStrategy();

        Race race = new Race(tryCount, carCount, moveStrategy);
        RaceResult result = race.start();

        output.showResult(result);
    }

}
