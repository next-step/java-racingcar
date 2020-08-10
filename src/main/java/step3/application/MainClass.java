package step3.application;

import step3.logic.Car;
import step3.view.input.InputScanner;
import step3.view.output.OutputText;
import step3.view.output.OutputView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainClass {

    public static void main(String[] args) {
        System.out.println(OutputText.CAR_COUNT_VIEW);
        int inputCarCount = InputScanner.scanInput();

        System.out.println(OutputText.CYCLE_COUNT_VIEW);
        int inputCycleCount = InputScanner.scanInput();
        System.out.println(OutputText.RESULT_TEXT);

        List<Car> cars = Stream.generate(Car::new)
                .limit(inputCarCount)
                .collect(Collectors.toList());

        for (int i = 0; i < inputCycleCount; i++) {
            cars.forEach(Car::makeCarMove);
            System.out.println();
        }
    }
}
