package edu.nextstep.camp;

import java.util.Collection;
import java.util.stream.Collectors;

import edu.nextstep.camp.model.car.Cars;
import edu.nextstep.camp.model.car.Name;
import edu.nextstep.camp.model.car.policy.RandomMovePolicy;
import edu.nextstep.camp.model.race.Race;
import edu.nextstep.camp.model.race.Turn;
import edu.nextstep.camp.view.InputView;
import edu.nextstep.camp.view.ResultView;

public class Main {
    private static final String DELIMITER = ",";
    private static final String NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String TURN_INPUT_MESSAGE = "시도할 회수는 몇 회 인가요?";

    public static void main(String[] args) {
        final Collection<Name> names = InputView.inputCSV(NAME_INPUT_MESSAGE, Name.NAME_LIMIT, DELIMITER)
                .stream()
                .map(Name::of)
                .collect(Collectors.toList());
        final Turn turns = Turn.of(InputView.inputPositiveNumber(TURN_INPUT_MESSAGE));

        final Cars cars = Cars.of(names, RandomMovePolicy.getInstance());
        final Race race = Race.of(cars, turns);
        while (!race.isEnded()) {
            race.process();
            ResultView.printResult(race.totalTurns(), race.gameResult());
        }

        ResultView.printWinners(race.winners());
    }
}
