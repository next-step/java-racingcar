package racingcar;

import java.util.List;
import java.util.stream.IntStream;

public class ConsoleOutputView implements OutputView{

    @Override
    public void showOutput(List<Car> cars) {
        cars.forEach(this::showDistanceOfCar);
        System.out.println();
    }

    @Override
    public void showOutputMessage() {
        System.out.println("Result of Racing");
    }

    @Override
    public void showRound(int round) {
        System.out.printf("Round %d\n", round);
    }

    private void showDistanceOfCar(Car car) {
        int distance = car.getDistance();
        StringBuilder stringBuilder = new StringBuilder();

        IntStream.range(0, distance).forEach(i -> stringBuilder.append('-'));

        System.out.println(stringBuilder);
    }
}
