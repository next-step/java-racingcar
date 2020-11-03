package study.step3.view;

import study.step3.domain.Car;
import study.step3.domain.Circuit;
import study.step3.domain.RealCar;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

public class InputView {
    public Circuit request() {
        String names = requestNames();

        Set<Car> cars = parseNames(names);

        int laps = requestLaps();
        return new Circuit(cars, laps);
    }

    private int requestLaps() {
        System.out.println("시도할 회수는 몇회인가요?");

        String laps = nextLine();
        if (!isInteger(laps)) {
            throw new IllegalArgumentException("횟수는 0 이상의 정수로 입력해 주세요.");
        }
        int lapsAsInteger = Integer.parseInt(laps);
        if (lapsAsInteger < 1) {
            throw new IllegalArgumentException("횟수는 0 이상의 정수로 입력해 주세요.");
        }

        return lapsAsInteger;
    }

    private boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private String requestNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

        String names = nextLine();
        if (names.isEmpty()) {
            throw new IllegalArgumentException("쉼표로 구분된 자동차 이름을 입력해주세요.");
        }

        return names;
    }

    protected String nextLine() {
        return new Scanner(System.in).nextLine();
    }

    private Set<Car> parseNames(String names) {
        return Arrays.stream(names.split(",")) //
                .map(RealCar::new) //
                .collect(toSet());
    }
}
