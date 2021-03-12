package racingcar;

import java.util.List;

public interface View {
    int getNumberOfCar();

    int getNumberOfRacing();

    List<String> getCarNames();

    void printTitle();

    void printSingleRacingResult(List<Car> cars);

    void printWinners(List<Name> winnersName);
}
