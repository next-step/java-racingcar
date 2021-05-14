package racingCar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ReadyTest {
    private String CAR_NAME;

    @BeforeEach
    void setUP() {
        CAR_NAME = "sung,ho,jun";
    }

    @Test
    @DisplayName("자동차 이름을 ,로 분리하는 테스트")
    void testSplitNameByComma() {
        // given
        Ready ready = new Ready();

        // when
        String[] expected = {"sung","ho","jun"};
        String[] actual = ready.splitNameByComma(CAR_NAME);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("숫자가 5 초과하는 경우 테스트")
    void testIsGreaterThanFive() {
        // given
        int number = 6;
        Ready ready = new Ready();

        // when
        boolean actual = ready.isGreaterThanFive(number);

        // then
        assertThat(actual).isEqualTo(true);
    }

    @Test
    @DisplayName("숫자가 5 이하인 경우 테스트")
    void testIsNotMoreThanFive() {
        // given
        int number = 5;
        Ready ready = new Ready();

        // when
        boolean actual = ready.isGreaterThanFive(number);

        // then
        assertThat(actual).isEqualTo(false);
    }

    @Test
    @DisplayName("정상 케이스 : 이름 길이가 5 이하 테스트")
    void testNameLengthIsNotMoreThanFive() {
        // given
        String name = "tomas";
        Ready ready = new Ready();

        // when
        String expected = "tomas";
        String actual = ready.checkNameLength(name);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("예외 케이스 : 이름 길이가 5 초과시 예외 처리 테스트")
    void testNameLengthIsGreaterThanFive() {
        // given
        String name = "sungmi";
        Ready ready = new Ready();

        // then
        assertThatIllegalArgumentException().isThrownBy(()
                -> ready.checkNameLength(name));
    }

    @Test
    @DisplayName("정상 케이스(이름 5자 이하) : 자동차 리스트 생성 테스트")
    void testCreateParticipantListByName() {
        // given
        Ready ready = new Ready();

        // when
        String[] expected = {"sung", "ho", "jun"};
        String[] actual = ready.createParticipantListByName(CAR_NAME);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("예외 케이스(이름 5자 초과) : 자동차 리스트 생성 실패 테스트")
    void testExceptionCreateParticipantListByName() {
        // given
        String name = "sssung,ho,jun";
        Ready ready = new Ready();

        // then
        assertThatIllegalArgumentException().isThrownBy(()
                -> ready.createParticipantListByName(name));
    }
}