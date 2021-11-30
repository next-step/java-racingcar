package step3;

import org.assertj.core.util.Strings;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class RacingCarTest {
    RacingCar racingCar = new RacingCar();

    /*@Test
    @DisplayName("0 ~ 9 범위의 랜덤한 숫자가 정상적으로 생성되었는지 확인합니다.")
    void getRandomNumber() {
        int expect = racingCar.getRandomNumber();
        assertThat(expect).isBetween(0, 9);
    }

    @ParameterizedTest()
    @CsvSource({"1, false", "4, false", "7, true"})
    @DisplayName("random 값이 4이상일 경우 전진하는지 확인합니다.")
    void isMove(int number, boolean expect) {
        boolean result = racingCar.isMove(number);
        assertThat(result).isEqualTo(expect);
    }*/

    @ParameterizedTest
    @ValueSource(strings = {"pobi","crong","honux"})
    @DisplayName("생성자를 통한 이름 필드 초기화가 정상적으로 되었는지 확인합니다.")
    void initialName(String name) {
        RacingCar racingCar = new RacingCar(name);
        assertThat(racingCar.getName()).isEqualTo(name);
    }

    @ParameterizedTest
    @ValueSource(strings = {"여섯글자이름", "abcdef"})
    @DisplayName("5자를 초과하는 이름으로 자동차 객체 생성시 IllegalArgumentException가 발생하는지 확인한다.")
    void illegalRarameter(String name) {
        assertThatIllegalArgumentException()
                .isThrownBy(() ->
                    {RacingCar racingCar = new RacingCar(name);}
                );
    }

    @Test
    @DisplayName("자동차가 전진하였을때 이동한 거리가 증가하였는지 확인합니다")
    void move() {
        int before = racingCar.getDistance();
        racingCar.move();
        int after = racingCar.getDistance();
        assertThat(before + 1).isEqualTo(after);
    }


}