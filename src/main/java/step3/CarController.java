package step3;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CarController {
    public static Scanner scanner = new Scanner(System.in);

    public void start() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        int numberOfCars = inputView.numberOfCars();
        int tryCounts = inputView.tryCount();

        CarList carList = initCarList(numberOfCars);

        outputView.resultMention();

        for(int tryNumber = 0; tryNumber < tryCounts; tryNumber++) {
            carList.nextPosition();
            carList.displayCurrentPosition(outputView);

        }

    }

    private CarList initCarList(int numberOfCars) {
        List<Car> carList = IntStream.range(0, numberOfCars)
                .mapToObj(i -> new Car())
                .collect(Collectors.toList());
        return CarList.from(carList);
    }

}
