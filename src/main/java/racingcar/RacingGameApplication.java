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

        System.out.println("자동차 대수는 몇 대 인가요?");
        int carCount = input.inputNumber();

        System.out.println("시도할 회수는 몇 회 인가요?");
        int tryCount = input.inputNumber();

        MoveStrategy moveStrategy = new MoveByRandomNumberStrategy();

        Race race = new Race(tryCount, carCount, moveStrategy);
        RaceResult result = race.start();

        output.showResult(carCount, result);
    }

}
