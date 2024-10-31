package racing.view;

import racing.entity.Car;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public List<Car> inputCar() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] names = scanner.nextLine().split(",");
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name.trim()));
        }
        return cars;
    }

    public int inputNumber() {
        System.out.println("시도할 횟수를 입력하세요 : ");
        return scanner.nextInt();
    }
}