package study.racing.view;

import study.racing.domain.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class InputView {
    private static InputView instance = new InputView();
    private static final Scanner scanner = new Scanner(in);

    public static int readTrialNumber() {
        out.println("시도할 회수는 몇 회 인가요?");
        int trialNumber = scanner.nextInt();
        return trialNumber;
    }

    public static String readCarNames() {
        out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.next();
    }

    public static List<Car> readCars(String carNames) {
        if (carNames.isEmpty()) {
            throw new RuntimeException("자동차를 입력하지 않았습니다.");
        }

        String[] names = carNames.split(",");
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(0, name));
        }
        return cars;
    }

    public static InputView getInstance() {
        return instance;
    }

    private InputView() {
    }
}
