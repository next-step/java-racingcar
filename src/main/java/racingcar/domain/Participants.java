package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.car.Car;
import racingcar.view.UserConsole;

public class Participants {

    private static final String NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String NAME_LENGTH_ERROR_MESSAGE = "자동차 이름이 5자를 초과합니다.";
    private static final String ERROR_LOG = "[ERROR] ";
    private final List<Car> cars;

    private Participants(List<Car> cars) {
        this.cars = cars;
    }

    public static Participants getInstance(List<Car> cars) {
        return new Participants(cars);
    }

    public static Participants createCars() {
        String[] names = UserConsole.getConsoleTextFrom(NAME_MESSAGE).split(",");
        List<Car> cars = new ArrayList<>();
        try {
            for (String name : names) {
                name = name.trim();
                validateCarName(name);
                Car car = Car.from(name);
                cars.add(car);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_LOG + e.getMessage());
            return createCars();
        }
        return Participants.getInstance(cars);
    }

    public static void validateCarName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR_MESSAGE);
        }
    }

    public void moveCarIfPositionChanged(int index, boolean bool) {
        if (bool) {
            this.cars.get(index).go();
        }
    }

    public static Participants toParticipants(RacingResult racingResult) {
        return Participants.getInstance(racingResult.getResult());
    }

    public List<Car> getParticipants() {
        return this.cars;
    }

    public int getParticipantCount() {
        return cars.size();
    }
}
