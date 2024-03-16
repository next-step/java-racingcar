package racingcar;

import racingcar.controller.Race;
import racingcar.domain.MoveByRandomNumberStrategy;
import racingcar.domain.MoveStrategy;
import racingcar.dto.RaceResult;
import racingcar.view.Input;
import racingcar.view.Output;

public class RacingGameApplication {

    public static void main(String[] args) {

        Input input = new Input();
        Output output = new Output();

        output.showCarCountInputRequestMessage();
        int carCount = input.inputNumber();

        output.showTryCountInputRequestMessage();
        int tryCount = input.inputNumber();

        MoveStrategy moveStrategy = new MoveByRandomNumberStrategy();

        Race race = new Race(tryCount, carCount, moveStrategy);
        RaceResult result = race.start();

        output.showResult(carCount, result);
    }

}
