package ui;

import domain.Car;

import java.util.*;

public class InputView {
    private static final String NAME_DELIMITER = ",";

    public static int getTryCount() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static List<Car> getCars() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        Scanner scanner = new Scanner(System.in);
        return createCars(scanner.nextLine());
    }

    static List<Car> createCars(String names) {
        List<Car> cars = new ArrayList<>();
        for (String name : Arrays.asList(names.split(NAME_DELIMITER))) {
            cars.add(new Car(name));
        }
        return Collections.unmodifiableList(cars);
    }

}
