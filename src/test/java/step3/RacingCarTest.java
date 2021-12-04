package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
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

    //증가하는 메소드를 호출할 때 증가 여부를 테스트해야하지 조건 확인 -> 증가를 테스트 하긴 불가능
    @Test
    @DisplayName("자동차가 전진하였을때 이동한 거리가 증가하였는지 확인합니다")
    void move() {
        RacingCar racingCar = new RacingCar(new Distance(0));
        int before = racingCar.getDistance();
        RandomValue randomValue = new RandomValue(5);
        racingCar.move(new RamdomCondition(randomValue));
        int after = racingCar.getDistance();
        assertThat(before + 1).isEqualTo(after);
    }

    @Test
    @DisplayName("random 값이 4이상일 경우 조건 만족, 4 미만일 경우 실패인지 확인한다")
    void isMove() {
        assertThat(new RacingCar(new Distance(0)).isMove(new RamdomCondition(new RandomValue(8)))).isTrue();
        assertThat(new RacingCar(new Distance(0)).isMove(new RamdomCondition(new RandomValue(2)))).isFalse();
    }
}