package carracing.view;

import carracing.domain.car.Car;
import carracing.domain.car.CarName;
import carracing.domain.car.Cars;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private final static Scanner scanner = new Scanner(System.in);

    public static Cars inputCars() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String[] inputCarNames = scanner.nextLine().split(",");

        List<Car> cars = new ArrayList<>();
        for (String inputCarName : inputCarNames) {
            cars.add(new Car(new CarName(inputCarName)));
        }

        return new Cars(cars);
    }

    public static int inputTryingNumber() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        int tryingNumber = scanner.nextInt();
        return tryingNumber;
    }
}
