package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public List<Car> carNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분");
        String value = scanner.nextLine();
        return splitCar(value);
    }

    public int carRunningNumber() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        String value = scanner.nextLine();
        return Integer.parseInt(value);
    }

    private List<Car> splitCar(String value) {
        String[] carNames = value.split(",");
        List<Car> carList = new ArrayList<>();
        for(String carName : carNames) {
            carList.add(new Car(new Name(carName), new Position(0)));
        }
        return carList;
    }
}
