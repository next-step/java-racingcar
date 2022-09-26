package view;

import domain.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String MAKE_CAR_COUNT = "자동차 대수는 몇 대 인가요?";
    private static final String PLAY_COUNT = "시도할 회수는 몇 회 인가요?";

    public static List<Car> getCarCount() {
        System.out.println(MAKE_CAR_COUNT);
        return makeCar(scanner.nextInt(getPositiveIntValue()));
    }

    public static List<Car> makeCar(int count) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            cars.add(new Car());
        }

        return cars;
    }

    public static int getPositiveIntValue() {
        int intValue = scanner.nextInt();
        if (intValue < 0) {
            throw new RuntimeException("0 이상의 숫자를 입력하세요.");
        }
        
        return intValue;
    }

    public static int getPlayCount() {
        System.out.println(PLAY_COUNT);
        return scanner.nextInt(getPositiveIntValue());
    }




}
