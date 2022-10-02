package racingcar;

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

    public void printResult(Cars cars) {
        System.out.println();
        System.out.println("실행 결과");
        for (Car car : cars.getCarList()) {
            printLocation(car);
            System.out.println();
        }
    }

    private void printLocation(Car car) {
        for (int i = 0; i < car.getLocation(); i++) {
            System.out.print("-");
        }
    }
}
