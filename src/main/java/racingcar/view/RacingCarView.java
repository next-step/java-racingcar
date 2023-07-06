package racingcar.view;

import racingcar.dto.Result;
import racingcar.dto.Winner;

import java.util.List;

public interface RacingCarView {

    void printCarNamesPrompt();

    void printCountPrompt();

    void printResults(List<List<Result>> results);

    void printResult(List<Result> result);

    void printWinners(List<Winner> winners);

    String read();
}
