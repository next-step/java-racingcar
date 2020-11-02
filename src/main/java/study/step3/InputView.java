package study.step3;

import java.util.Arrays;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

class InputView {
    public Circuit request() {
        String names = requestNames();

        Set<Car> cars = parseNames(names);

        int laps = requestLaps();
        return new Circuit(cars, laps);
    }

    private int requestLaps() {
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
        String names = nextLine();
        if (names.isEmpty()) {
            throw new IllegalArgumentException("쉼표로 구분된 자동차 이름을 입력해주세요.");
        }

        return names;
    }

    protected String nextLine() {
        return null;
    }

    private Set<Car> parseNames(String names) {
        return Arrays.stream(names.split(",")) //
                .peek(name -> {
                    if (name.length() > 5) {
                        throw new IllegalArgumentException("이름은 5자를 넘을 수 없습니다.");
                    }
                }).map(RealCar::new) //
                .collect(toSet());
    }
}
