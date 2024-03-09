package racingcar.step3.print;

import racingcar.step3.Car;

import java.util.List;

public interface PrintStrategy {

    public void printRoundResult(List<Car> cars);
}
