package racingcar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Participants;
import racingcar.domain.car.Car;

public class UserInput {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final String NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String TURN_MESSAGE = "시도할 횟수는 몇번인가요?";

    public static Participants createCars() {
        String[] names = getInputValueWithMessage(NAME_MESSAGE).split(",");
        List<Car> cars = new ArrayList<>();
        try {
            for (String name : names) {
                name = name.trim();
                validateCarName(name);
                Car car = Car.from(name);
                cars.add(car);
            }
        } catch (IllegalArgumentException e) {
            return createCars();
        }
        return Participants.getInstance(cars);
    }

    public static int setTurn() {
        return Integer.parseInt(getInputValueWithMessage(TURN_MESSAGE));
    }

    public static String getInputValueWithMessage(String message) {
        try {
            System.out.println(message);
            String line = br.readLine().trim();
            return line;
        } catch (IOException e) {
            return getInputValueWithMessage(message);
        }
    }

    private static void validateCarName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름이 5자를 초과합니다.");
        }
    }
}
