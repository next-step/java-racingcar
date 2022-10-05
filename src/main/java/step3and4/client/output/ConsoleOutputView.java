package step3and4.client.output;

import step3and4.game.car.Cars;

import java.util.List;

public class ConsoleOutputView implements OutputView {

    @Override
    public void print(Cars cars) {
        List<String> positionsAndNames = cars.positionsAndNames();
        positionsAndNames.forEach(System.out::println);
        System.out.println();
    }

}
