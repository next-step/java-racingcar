package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class RacingCarTest {
    @ParameterizedTest
    @ValueSource(strings = {"pobi", "crong", "honux"})
    @DisplayName("생성자를 통한 이름 필드 초기화가 정상적으로 되었는지 확인합니다.")
    void initialName(String name) {
        RacingCar racingCar = new RacingCar(new Distance(0), new Name(name));
        assertThat(racingCar.equals(new RacingCar(new Distance(0), new Name(name)))).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"pobi : pobi", "crong : crong", "honux : choco"}, delimiter = ':')
    @DisplayName("생성자를 통한 이름 필드 초기화가 비정상적으로 되었는지 확인합니다.")
    void uninitialName(String initialCarNames, String compareName) {
        RacingCar racingCar = new RacingCar(new Distance(0), new Name(initialCarNames));
        assertThat(racingCar.equals(new RacingCar(new Distance(0), new Name(compareName)))).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"여섯글자이름", "abcdef"})
    @DisplayName("5자를 초과하는 이름으로 자동차 객체 생성시 IllegalArgumentException가 발생하는지 확인한다.")
    void illegalRarameter(String name) {
        assertThatIllegalArgumentException()
                .isThrownBy(() ->
                        {
                            new RacingCar(new Distance(0), new Name(name));
                        }
                );
    }

    @ParameterizedTest
    @CsvSource({"1, 2", "3, 4"})
    @DisplayName("자동차가 전진하였을때 이동한 거리가 증가하였는지 확인합니다")
    void move(int initialValue,  int movedValue) {
        RacingCar racingCar = new RacingCar(new Distance(initialValue)).move(new RamdomCondition(new RandomValue(5)));
        assertThat(racingCar.equals(new RacingCar(new Distance(movedValue)))).isTrue();
    }

    @Test
    @DisplayName("random 값이 4이상일 경우 조건 만족, 4 미만일 경우 실패인지 확인한다")
    void isMove() {
        assertThat(new RacingCar(new Distance(0)).isMove(new RamdomCondition(new RandomValue(8)))).isTrue();
        assertThat(new RacingCar(new Distance(0)).isMove(new RamdomCondition(new RandomValue(2)))).isFalse();
    }
}