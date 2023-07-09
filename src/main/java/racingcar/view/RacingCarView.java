package racingcar.view;

import racingcar.dto.Results;
import racingcar.dto.Winners;

import java.util.List;

public interface RacingCarView {

    void printCarNamesPrompt();

    void printCountPrompt();

    void printResults(List<Results> totalResult);

    void printResult(Results results);

    void printWinners(Winners winners);

    String read();
}
