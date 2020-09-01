package racing.core.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.core.exception.ErrorMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CarsTest {

    private String[] names = {"test1", "test2", "test3"};

    @Test
    @DisplayName("생성자에서 리스트에 대한 검증")
    void createCars() {
        Cars cars = Cars.of(names);
        assertNotNull(cars);
    }

    @Test
    @DisplayName("생성자에서 빈 리스트에 대한 검증")
    void createCarsWithEmptyList() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Cars cars = Cars.of(new String[]{});
        }).withMessage(ErrorMessage.EMPTY_CARS.getMessage());
    }

    @Test
    @DisplayName("모든 자동차가 이동한 runTrial 결과 테스트")
    void runTrialAllMoved() {
        // when
        Cars actual = Cars.of(names).runTrial(() -> true);

        // then
        List<Car> before = parseCar(names);
        List<Car> after = new ArrayList<>();

        for (Car car : before) {
            after.add(car.move(() -> true));
        }
        Cars expected = Cars.of(after);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("모든 자동차가 정지한 runTrial 결과 테스트")
    void runTrialAllStopped() {
        // given
        Cars actual = Cars.of(names).runTrial(() -> false);

        // then
        List<Car> before = parseCar(names);
        List<Car> after = new ArrayList<>();

        for (Car car : before) {
            after.add(car.move(() -> false));
        }
        Cars expected = Cars.of(after);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("runTrial 결과 테스트")
    void runTrial() {
        // given
        Car first = new Car(names[0]);
        Car second = new Car(names[1]);
        Car third = new Car(names[2]);

        first = first.move(() -> true);

        Cars cars = Cars.of(Arrays.asList(first, second, third));

        // when
        Cars actual = cars.runTrial(() -> false);

        // then
        Cars expected = Cars.of(Arrays.asList(
                new Car(first.getName(), 1),
                new Car(second.getName(), 0),
                new Car(third.getName(), 0)
        ));

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("우승자 이름 테스트")
    void getWinner() {
        // given
        Car winner = new Car(names[0]);
        Car second = new Car(names[1]);
        Car third = new Car(names[2]);

        winner = winner.move(() -> true);
        Cars cars = Cars.of(Arrays.asList(winner, second, third));

        cars = cars.runTrial(() -> false);

        // when
        List<Car> actual = cars.getWinners();

        // then
        List<Car> expected = Arrays.asList(winner);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("공통 우승자 이름 테스트")
    void getCoWinners() {
        // given
        List<Car> participants = Arrays.stream(names)
                .map(Car::new)
                .collect(Collectors.toList());
        Cars cars = Cars.of(participants);
        cars.runTrial(() -> true);

        // when
        List<Car> actual = cars.getWinners();

        // then
        assertEquals(participants, actual);
    }

    private List<Car> parseCar(String[] namesOfCars) {
        return Arrays.stream(namesOfCars)
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
