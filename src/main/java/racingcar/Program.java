package racingcar;

import racingcar.control.input.CarInput;
import racingcar.control.input.StandardInput;
import racingcar.control.input.TrialInput;
import racingcar.control.output.ConsoleOutput;
import racingcar.control.output.RacingOutput;
import racingcar.model.Car;
import racingcar.model.Racing;
import racingcar.strategy.RandomMovingStrategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Program {
    public static void main(String[] args) {
        StandardInput carInput = new CarInput();
        StandardInput trialInput = new TrialInput();

        int carCount = carInput.getInt();
        int trials = trialInput.getInt();

        List<Car> cars = Stream
                .generate(() -> new Car(new RandomMovingStrategy()))
                .limit(carCount)
                .collect(Collectors.toList());

        Racing racing = new Racing(trials, cars);

        ConsoleOutput racingOutput = new RacingOutput(racing);
        while (!racing.isOver()) {
            racing.step();
            racingOutput.print();
        }
    }
}
