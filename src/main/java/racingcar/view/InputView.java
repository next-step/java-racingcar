package racingcar.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import racingcar.domain.Car;

public class InputView {

    private static final Scanner sc = new Scanner(System.in);

    private InputView() {
    }

    public static List<Car> inputName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String namesString = sc.nextLine();
        String[] carNames = namesString.trim().split(",");
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    public static int inputTimes() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return sc.nextInt();
    }

}