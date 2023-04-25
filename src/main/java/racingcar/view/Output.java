package racingcar.view;

import racingcar.domain.CarDto;
import racingcar.domain.Race;

public interface Output {

    void printPosition(CarDto carDto);

    void printExecutionHeader();

    void printBlankLine();

    void printPositions(Race race);

    void printWinner(Race race);
}
