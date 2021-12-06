package racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarsTest {
    @ParameterizedTest
    @CsvSource(value = {"1 : 1", "5 : 5", "10 : 10"}, delimiter = ':')
    @DisplayName("자동차 게임에 참여하는 이름을 가진 자동차들이 정상적으로 객체 생성 되었는지 확인합니다")
    void equals(int initialCarCount, int compareCarCount) {
        assertThat(new RacingCars(initialCarCount).equals(new RacingCars(compareCarCount))).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1 : 7", "5 : 0", "9 : 10"}, delimiter = ':')
    @DisplayName("자동차 게임에 참여하는 이름을 가진 자동차들이 비정상적으로 객체 생성 되었는지 확인합니다")
    void notEquals(int initialCarCount, int compareCarCount) {
        assertThat(new RacingCars(initialCarCount).equals(new RacingCars(compareCarCount))).isFalse();
    }

    @ParameterizedTest
    @CsvSource(value = {"pobi,crong,choco : pobi,crong,choco"}, delimiter = ':')
    @DisplayName("자동차 게임에 참여하는 이름을 가진 자동차들이 정상적으로 객체 생성 되었는지 확인합니다")
    void equals(String initialCarNames, String compareCarNames) {
        assertThat(new RacingCars(initialCarNames.split(",")).equals(new RacingCars(compareCarNames.split(",")))).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"pobi,crong,honux : pobi,crong,choco"}, delimiter = ':')
    @DisplayName("자동차 게임에 참여하는 이름을 가진 자동차들이 비정상적으로 객체 생성 되었는지 확인합니다")
    void notEquals(String initialCarNames, String compareCarNames) {
        assertThat(new RacingCars(initialCarNames.split(",")).equals(new RacingCars(compareCarNames.split(",")))).isFalse();
    }

    @Test
    @DisplayName("실제 우승자들이 정상적으로 출력되는지 확인합니다.")
    void getWinner() {
        RacingCar pobi = new RacingCar(new Distance(0), new Name("pobi"));
        RacingCar crong = new RacingCar(new Distance(1), new Name("crong"));
        RacingCar honux = new RacingCar(new Distance(2), new Name("honux"));
        RacingCar choco = new RacingCar(new Distance(2), new Name("choco"));
        RacingCar titi = new RacingCar(new Distance(2), new Name("titi"));

        RacingCars racingCars = new RacingCars(Arrays.asList(pobi, crong, honux, choco, titi));
        assertThat(racingCars.getWinner()).contains(honux, choco, titi);
    }
}
