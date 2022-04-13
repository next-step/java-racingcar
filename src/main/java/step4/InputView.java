package step4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public List<Car> carNameQuestion() throws Exception {
        List<Car> cars = new ArrayList<>();

        System.out.println("경주할 자동차 이름을 입력하새요(이름은 쉼표(,)를 긔준으로 구분).");
        String answer = scanner.nextLine();
        String[] carNames = answer.split(",");
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }

    public int attemptCountQuestion() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        return scanner.nextInt();
    }
}
