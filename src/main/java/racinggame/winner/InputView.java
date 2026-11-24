package racinggame.winner;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

final class InputView {

    private InputView() {
    }

    static Cars readCars(Scanner scanner) {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String[] names = scanner.nextLine().split(",", -1);
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            String trimmedName = name.trim();
            if (trimmedName.isEmpty()) {
                throw new IllegalArgumentException("자동차 이름을 입력해야 합니다.");
            }
            cars.add(new Car(trimmedName, 0));
        }
        return new Cars(cars);
    }

    static RacingCount readRacingCount(Scanner scanner) {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = scanner.nextLine().trim();
        try {
            return new RacingCount(Integer.parseInt(input));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력해야 합니다.", e);
        }
    }
}
