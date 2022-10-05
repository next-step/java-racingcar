package racingcar;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Location;
import racingcar.domain.Name;

import java.util.Scanner;

public class View {
    public static final Scanner scanner = new Scanner(System.in);

    public String inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.nextLine();
    }

    public int inputTrialCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }

    public void printResult() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void printTrial(Cars cars) {
        for (Car car : cars.getCars()) {
            printCar(car);
            System.out.println();
        }
        System.out.println();
    }

    private void printCar(Car car) {
        printName(car.getName());
        System.out.print(" : ");
        printLocation(car.getLocation());
    }

    private void printName(Name name) {
        System.out.print(name.getName());
    }

    private void printLocation(Location location) {
        for (int i = 0; i < location.getLocation(); i++) {
            System.out.print("-");
        }
    }
}
