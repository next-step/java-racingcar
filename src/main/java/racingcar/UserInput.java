package racingcar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import racingcar.domain.car.Car;

public class UserInput {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final String NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String TURN_MESSAGE = "시도할 횟수는 몇번인가요?";

    public static void createCars() {
        String[] names = getInputValueWithMessage(NAME_MESSAGE).split(",");
        for (String name : names) {
            Car car = Car.from(name.trim());
        }
    }

    public static void setTurn() {
        int turn = Integer.parseInt(getInputValueWithMessage(TURN_MESSAGE));
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
}
