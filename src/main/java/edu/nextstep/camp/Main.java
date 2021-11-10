package edu.nextstep.camp;

import java.util.List;

import edu.nextstep.camp.view.InputView;
import edu.nextstep.camp.view.ResultView;

public class Main {
    private static final String DELIMITER = ",";

    public static void main(String[] args) {
        final InputView input = new InputView();

        final String[] names = input.inputCSV("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).", Car.NAME_LIMIT, DELIMITER);
        final int turns = input.inputPositiveNumber("시도할 회수는 몇 회 인가요?");

        final ResultView result = new ResultView(turns);

        final List<Car> cars = Car.of(names, RandomMovePolicy.getInstance());
        final Race race = Race.of(cars, turns);
        while (!race.isEnded()) {
            race.process();
            result.printResult(race.gameResult());
        }

        result.printWinners(race.winners());
    }
}
