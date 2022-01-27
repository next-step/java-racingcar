package racingcar.domain.car;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.racing.RacingResult;
import racingcar.domain.random.RandomGenerator;
import racingcar.view.UserConsole;

public class Participants {

    private static final String NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String ERROR_LOG = "[ERROR] ";
    private final List<Car> cars;

    public Participants(List<Car> cars) {
        this.cars = cars;
    }

    public static Participants createCars() {
        String[] names = UserConsole.getConsoleTextFrom(NAME_MESSAGE).split(",");
        List<Car> cars = new ArrayList<>();
        try {
            for (String name : names) {
                name = name.trim();
                Car car = Car.from(name);
                cars.add(car);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_LOG + e.getMessage());
            return createCars();
        }
        return new Participants(cars);
    }

    public RacingResult race() {
        cars.stream().forEach(car -> car.go(new RandomGenerator()));

        return RacingResult.getInstance(cars);
    }

    public List<Car> getParticipants() {
        return this.cars;
    }
}
