package RacingCar;

import java.util.List;

public interface OutputView {
    void printTitle();
    void printSingleRacingResult(List<Car> cars);
    void printWinners(List<Car> cars);
}
