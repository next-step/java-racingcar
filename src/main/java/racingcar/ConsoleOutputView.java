package racingcar;

import java.util.List;

public class ConsoleOutputView implements OutputView{

    @Override
    public void showOutput(List<Car> cars) {
        cars.forEach(System.out::println);
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
}
