package racingcar.view;

import racingcar.Car;
import racingcar.Cars;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {
    private Scanner scanner;
    private int carsSize;
    private int rounds;

    private List<Car> cars = new ArrayList<>();

    public InputView() {
        scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        carsSize = scanner.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        rounds = scanner.nextInt();
    }

    public Cars initCars() {
        return new Cars(IntStream.range(0, this.carsSize)
                .mapToObj(i -> new Car(0))
                .collect(Collectors.toList()));
    }

    public int getRounds() {
        return this.rounds;
    }
}
