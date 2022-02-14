package racinggame.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RacingTest {

    final static List<String> testCarNames = Arrays.asList("123", "456", "789");

    @DisplayName("자동차 이름을 이용해 자동차를 등록할 수 있다")
    @Test
    void 이름을_통한_자동차_등록() {
        Racing game = Racing.fromCarNames(testCarNames);

        List<Car> expected = Arrays.asList(new Car("123"), new Car("456"), new Car("789"));
        List<Car> actual = game.getCarInfo();

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("랜덤 넘버가 4 이상이면 자동차는 전진할 수 있다")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @ParameterizedTest
    void 사_이상일_경우_전진_가능(final int number) {
        Racing game = Racing.fromCarNames(testCarNames);
        assertThat(game.isMovable(number)).isTrue();
    }

    @DisplayName("랜덤 넘버가 4 미만이면 자동차는 전진할 수 없다")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @ParameterizedTest
    void 사_미만일_경우_전진_불가능(final int number) {
        Racing game = Racing.fromCarNames(testCarNames);
        assertThat(game.isMovable(number)).isTrue();
    }

    @DisplayName("전진이 가능할 경우, 자동차는 1 전진하고 아니면 정지한다")
    @Test
    void 자동차_전진_확인() {
        Car testCar1 = Car.of("test1");
        Car testCar2 = Car.of("test2");
        Racing game = Racing.fromCarNames(testCarNames);
        game.moveCar(testCar1, true);
        game.moveCar(testCar2, false);
        assertThat(testCar1.getLocation()).isEqualTo(1);
        assertThat(testCar2.getLocation()).isEqualTo(0);
    }

    @DisplayName("가장 멀리 간 자동차가 우승자다")
    @Test
    void 우승자_확인() {
        List<Car> cars = Arrays.asList(
            new Car("test1", 4),
            new Car("test2", 5),
            new Car("test3", 2)
        );
        Racing game = Racing.fromCars(cars);
        List<String> winners = game.getWinnersName();

        assertThat(winners).containsExactly("test2");
    }

    @DisplayName("최대 거리가 같을 경우, 공동 우승이 가능하다")
    @Test
    void 공동_우승자_확인() {
        List<Car> cars = Arrays.asList(
            new Car("test1", 5),
            new Car("test2", 3),
            new Car("test3", 5)
        );
        Racing game = Racing.fromCars(cars);
        List<String> winners = game.getWinnersName();
        assertThat(winners).containsExactly("test1", "test3");
    }

    @DisplayName("우승자는 항상 1명 이상이다")
    @RepeatedTest(10)
    void 우승자_존재_확인() {
        Racing game = Racing.fromCarNames(testCarNames);

        for (int i = 0; i < 3; i++) {
            game.race();
        }

        int winnerCount = game.getWinnersName().size();
        assertThat(winnerCount).isGreaterThanOrEqualTo(1);
    }
}
