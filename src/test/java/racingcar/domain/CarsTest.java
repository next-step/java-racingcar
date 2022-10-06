package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.nickname.Nickname;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    private List<String> names;

    @BeforeEach
    void setUp() {
        names = List.of("apple", "boost", "jung", "play");
    }

    @Test
    @DisplayName("이름 목록으로 자동차 목록이 생성된다.")
    void of() {
        List<Car> cars = names.stream()
                .map(name -> new Car(new Nickname(name), new Position(0)))
                .collect(Collectors.toList());
        Cars expected = new Cars(cars);

        Cars actual = Cars.of(names);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("자동차들이 이동한다.")
    void move() {
        List<Car> expected = names.stream()
                .map(name -> new Car(new Nickname(name), new Position(1)))
                .collect(Collectors.toList());
        Cars cars = Cars.of(names);

        List<Car> actual = cars.move(new SuccessCondition());

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("우승한 자동차들을 알려준다.")
    void findWinners() {
        Winners expected = new Winners(List.of(
                new Car(new Nickname(names.get(1)), new Position(3)),
                new Car(new Nickname(names.get(3)), new Position(3))
        ));
        List<Car> movedCars = List.of(
                new Car(new Nickname(names.get(0)), new Position(1)),
                new Car(new Nickname(names.get(1)), new Position(3)),
                new Car(new Nickname(names.get(2)), new Position(2)),
                new Car(new Nickname(names.get(3)), new Position(3))
        );
        Cars cars = new Cars(movedCars);

        Winners actual = cars.findWinners();

        assertThat(actual).isEqualTo(expected);
    }
}
