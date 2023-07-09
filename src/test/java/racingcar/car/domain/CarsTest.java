package racingcar.car.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    Cars cars;

    @BeforeEach
    void beforeEach() {
        cars = new Cars(List.of(
            new Car(3, "a"),
            new Car(4, "b"),
            new Car(5, "c")));
    }

    @Test
    @DisplayName("position 값이 가장 큰 자동차를 우승자로 선출한다.")
    void getWinners_returnMaxPositionCars() {
        List<Car> winners = cars.getWinners();

        winners.forEach(winner -> {
                assertThat(winner.matchPosition(5)).isTrue();
                assertThat(winner.getNameValue()).isEqualTo("c");
        });
    }

    @Test
    @DisplayName("MoveStrategy 에 의해 움직일 수 있다고 판단되면 자동차는 한 스텝 이동한다.")
    void move_givenAlwaysTrueMoveStrategy_moveOneStep() {
        List<Integer> initPositions = extractCarPositions();

        // 항상 움직일 수 있음.
        cars.move(() -> true);

        List<Integer> resultPositions = extractCarPositions();
        for (int i = 0; i < resultPositions.size(); i++) {
            assertThat(resultPositions.get(i)).isEqualTo(initPositions.get(i)+1);
        }
    }

    @Test
    @DisplayName("MoveStrategy 에 의해 움직일 수 없다고 자동차는 움직이지 않는다.")
    void move_givenAlwaysFalseMoveStrategy_doNotMove() {
        List<Integer> initPositions = extractCarPositions();

        // 항상 움직일 수 없음.
        cars.move(() -> false);

        List<Integer> resultPositions = extractCarPositions();
        for (int i = 0; i < resultPositions.size(); i++) {
            assertThat(resultPositions.get(i)).isEqualTo(initPositions.get(i));
        }
    }

    private List<Integer> extractCarPositions() {
        return cars.getCars().stream()
            .mapToInt(Car::getPosition)
            .boxed()
            .collect(Collectors.toList());
    }
}
