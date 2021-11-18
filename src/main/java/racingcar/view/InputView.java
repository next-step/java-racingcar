package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private Scanner scanner;
    private String carNames;
    private String[] names;
    private int rounds;

    private List<Car> cars = new ArrayList<>();

    public InputView() {
        scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        carNames = scanner.next();
        names = carNames.split(",");

        System.out.println("시도할 회수는 몇 회 인가요?");
        rounds = scanner.nextInt();
    }

    public Cars initCars() {
        return new Cars(Arrays.stream(names).map(name -> new Car(name)).collect(Collectors.toList()));
    }

    public int getRounds() {
        return this.rounds;
    }
}
