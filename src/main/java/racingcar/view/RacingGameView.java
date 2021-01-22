package racingcar.view;
import racingcar.domain.Car;
import java.util.List;

public interface RacingGameView {
    String[] inputCarNames();
    int inputPlayCount();
    void printWinner(List<Car> winners);
    void printCars(List<Car> cars);
}