package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public interface Output {

    void println(final String outputMessage);

    void printMidResult(List<Car> cars);

    void printWinners(List<String> winners);
}
