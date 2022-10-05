package racingcar;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Location;

import java.util.List;
import java.util.Scanner;

public class View {
    public static final Scanner scanner = new Scanner(System.in);

    public int inputCarCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return scanner.nextInt();
    }

    public int inputTrialCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }

    public void printResult(List<Cars> trials) {
        System.out.println();
        System.out.println("실행 결과");
        for (Cars cars : trials) {
            printTrial(cars);
            System.out.println();
        }
    }

    private void printTrial(Cars cars) {
        for (Car car : cars.getCars()) {
            printLocation(car.getLocation());
            System.out.println();
        }
    }

    private void printLocation(Location location) {
        for (int i = 0; i < location.getLocation(); i++) {
            System.out.print("-");
        }
    }
}
