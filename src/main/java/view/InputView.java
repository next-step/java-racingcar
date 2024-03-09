package view;

import model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public List<Car> askCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

        try {
            return toCars(SCANNER.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        return askCarNames();
    }

    private List<Car> toCars(String input) {
        String[] names = input.split(",");

        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }

        return cars;
    }

    public int askRacingTurn() {
        System.out.println("시도할 회수는 몇 회 인가요?");

        try {
            return toInt(SCANNER.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        return askRacingTurn();
    }

    private int toInt(String input) {
        int value = Integer.parseInt(input);

        assertOneOrMore(value);

        return value;
    }

    private void assertOneOrMore(int value) {
        if (value < 1) {
            throw new IllegalArgumentException("1 이상의 수를 입력하세요");
        }
    }
}
