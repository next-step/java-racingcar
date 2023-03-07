package racingCar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RacingHostTest {

    @DisplayName("레이싱 전체 동작 테스트")
    @Test
    void raceStartTest() {
        // given
        System.setIn(new ByteArrayInputStream("pobi,woni,jun\n5".getBytes()));

        // when
        RacingCar racingCar = new RacingCar();

        // then
        assertThatCode(racingCar::start).doesNotThrowAnyException();
    }

    @DisplayName("이름 5글자 규칙에 어긋나는 입력값 예외 처리 테스트")
    @Test
    void racingInputLengthErrorTest() {
        // given
        System.setIn(new ByteArrayInputStream("pobi,woni,november\n5".getBytes()));

        // when
        RacingCar racingCar = new RacingCar();

        // then
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(racingCar::start).isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("자동차 이름을 받아 객체 초기화 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"pobi,woni,jun"})
    void initCarTest(String input) {
        // given
        RacingHost rh = new RacingHost();

        // when
        ArrayList<Car> garage = rh.initCar(input);

        // then
        assertThat(garage.size()).isEqualTo(3);
    }

    @DisplayName("사용자 입력 값이 제대로 들어오는지 테스트")
    @Test
    void inputStringTest() {
        // given
        RacingHost rh = new RacingHost();

        // when
        System.setIn(new ByteArrayInputStream("pobi,woni,jun\n5".getBytes()));
        rh.inputCarNameAndTryNumber();

        // then
        assertThat(rh.garage.size()).isEqualTo(3);
        assertThat(rh.inputTryNumber).isEqualTo(5);
    }

    @DisplayName("경주 수행 테스트")
    @Test
    void racingTest() {
        // given
        RacingHost rh = new RacingHost();

        // when
        System.setIn(new ByteArrayInputStream("pobi,woni,jun\n5".getBytes()));
        rh.inputCarNameAndTryNumber();

        // then
        assertThatCode(() -> rh.racing(rh.garage)).doesNotThrowAnyException();
    }

    @DisplayName("랜덤함수 뽑기 테스트")
    @Test
    void drawTest() {
        // given
        RacingHost rh = new RacingHost();

        // when
        int test = rh.draw();

        // then
        assertThat(test).isInstanceOf(Integer.class);
        assertThat(test).isGreaterThan(-1);
    }

    @DisplayName("우승자 결정 테스트")
    @Test
    void chooseWinnerTest() {
        // given
        RacingHost rh = new RacingHost();
        String intputName = "pobi,woni,jun";

        // when
        rh.garage = rh.initCar(intputName);
        rh.racing(rh.garage);

        // then
        assertThatCode(() -> rh.chooseWinner(rh.garage)).doesNotThrowAnyException();
    }
}
