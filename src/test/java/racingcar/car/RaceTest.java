package racingcar.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.random.TestFixedNumberGenerator;
import racingcar.random.TestFixedNumbersGenerator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.groups.Tuple.*;

class RaceTest {

    @DisplayName("이름 리스트로 자동차들을 초기화 할 수 있다")
    @Test
    void of() {
        // given
        TestFixedNumberGenerator testFixedNumberGenerator = new TestFixedNumberGenerator(3);
        List<String> carNames = List.of("green", "blue", "red");

        // when
        Race race = Race.of(carNames, testFixedNumberGenerator);

        // then
        assertThat(race.getCars())
                .hasSize(3)
                .extracting("name", "position")
                .containsExactlyInAnyOrder(
                        tuple("green", 1),
                        tuple("blue", 1),
                        tuple("red", 1)
                );
    }

    @DisplayName("난수값이 4이상이면 자동차를 1만큼 움직인다.")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 9, 100})
    void moveCars(int randomNumber) {
        // given
        TestFixedNumberGenerator testFixedNumberGenerator = new TestFixedNumberGenerator(randomNumber);
        List<String> carNames = List.of("green");
        Race race = Race.of(carNames, testFixedNumberGenerator);

        // when
        race.moveCars();

        // then
        assertThat(race.getCars())
                .hasSize(1)
                .element(0)
                .extracting("position")
                .isEqualTo(2);
    }

    @DisplayName("난수 값이 4미만이면 자동차를 움직이지 못한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void noMoveCars(int randomNumber) {
        // given
        TestFixedNumberGenerator testFixedNumberGenerator = new TestFixedNumberGenerator(randomNumber);
        List<String> carNames = List.of("green");
        Race race = Race.of(carNames, testFixedNumberGenerator);

        // when
        race.moveCars();

        // then
        assertThat(race.getCars())
                .hasSize(1)
                .element(0)
                .extracting("position")
                .isEqualTo(1);
    }

    @DisplayName("자동차 목록에서 전진 조건을 만족하는 자동차를 움직일 수 있다.")
    @Test
    void moveCarsWithEachDistance() {
        // given
        TestFixedNumbersGenerator testFixedNumberGenerator = new TestFixedNumbersGenerator(List.of(1, 6, 3));
        List<String> carNames = List.of("green", "blue", "red");
        Race race = Race.of(carNames, testFixedNumberGenerator);

        // when
        race.moveCars();

        // then
        assertThat(race.getCars())
                .hasSize(3)
                .extracting("name", "position")
                .containsExactlyInAnyOrder(
                        tuple("green", 1),
                        tuple("blue", 2),
                        tuple("red", 1)
                );
    }

    @DisplayName("3대의 자동차 목록에서 전진 조건을 만족하는 자동차를 n번 움직일 수 있다.")
    @ParameterizedTest
    @CsvSource({"1,1,2,1", "2,1,3,1", "3,1,4,1", "4,2,5,1", "5,3,5,1"})
    void moveCarsMultipleTimes(int round, int position1, int position2, int position3) {
        // given
        TestFixedNumbersGenerator testFixedNumberGenerator = new TestFixedNumbersGenerator(List.of(
                1, 6, 3,
                1, 4, 2,
                3, 8, 1,
                6, 6, 3,
                4, 3, 2
        ));
        List<String> carNames = List.of("green", "blue", "red");
        Race race = Race.of(carNames, testFixedNumberGenerator);

        // when
        for (int i = 0; i < round; i++) {
            race.moveCars();
        }

        // then
        assertThat(race.getCars())
                .hasSize(3)
                .extracting("name", "position")
                .containsExactlyInAnyOrder(
                        tuple("green", position1),
                        tuple("blue", position2),
                        tuple("red", position3)
                );
    }

    @DisplayName("3대의 자동차 목록에서 3라운드동안 가장 멀리 이동한 자동차 1대를 찾을 수 있다.")
    @Test
    void getOneWinner() {
        // given
        TestFixedNumbersGenerator testFixedNumberGenerator = new TestFixedNumbersGenerator(List.of(
                1, 6, 3,
                1, 4, 2,
                3, 8, 1
        ));
        List<String> carNames = List.of("green", "blue", "red");
        Race race = Race.of(carNames, testFixedNumberGenerator);

        for (int i = 0; i < 3; i++) {
            race.moveCars();
        }
        // when
        List<String> result = race.getWinners();

        // then
        assertThat(result).hasSize(1)
                .containsExactly("blue");
    }

    @DisplayName("3대의 자동차 목록에서 3라운드동안 가장 멀리 이동한 자동차 2대를 찾을 수 있다.")
    @Test
    void getTwoWinners() {
        // given
        TestFixedNumbersGenerator testFixedNumberGenerator = new TestFixedNumbersGenerator(List.of(
                7, 9, 3,
                8, 8, 2,
                9, 5, 1
        ));
        List<String> carNames = List.of("green", "blue", "red");
        Race race = Race.of(carNames, testFixedNumberGenerator);

        for (int i = 0; i < 3; i++) {
            race.moveCars();
        }
        // when
        List<String> result = race.getWinners();

        // then
        assertThat(result).hasSize(2)
                .containsExactlyInAnyOrder("green", "blue");
    }

    @DisplayName("3대의 자동차 목록에서 3라운드동안 가장 멀리 이동한 자동차 3대를 찾을 수 있다.")
    @Test
    void getThreeWinners() {
        // given
        TestFixedNumbersGenerator testFixedNumberGenerator = new TestFixedNumbersGenerator(List.of(
                7, 9, 8,
                8, 8, 4,
                9, 5, 4
        ));
        List<String> carNames = List.of("green", "blue", "red");
        Race race = Race.of(carNames, testFixedNumberGenerator);

        for (int i = 0; i < 3; i++) {
            race.moveCars();
        }
        // when
        List<String> result = race.getWinners();

        // then
        assertThat(result).hasSize(3)
                .containsExactlyInAnyOrder("green", "blue", "red");
    }
}