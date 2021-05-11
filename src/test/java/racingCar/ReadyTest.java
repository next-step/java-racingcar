package racingCar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

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
        String[] expecte = {"sung","ho","jun"};
        String[] acual = ready.splitNameByComma(CAR_NAME);

        // then
        assertThat(acual).isEqualTo(expecte);
    }

    @Test
    @DisplayName("자동차 이름 길이가 5 초과하는 경우 테스트")
    void testIsGreaterThanFive() {
        // given
        String name = "tomato";
        Ready ready = new Ready();

        // when
        boolean actual = ready.isGreaterThanFive(name);

        // then
        assertThat(actual).isEqualTo(true);
    }

    @Test
    @DisplayName("자동차 이름 길이가 5 이하인 경우 테스트")
    void testIsNotMoreThanFive() {
        // given
        String name = "tomas";
        Ready ready = new Ready();

        // when
        boolean actual = ready.isGreaterThanFive(name);

        // then
        assertThat(actual).isEqualTo(false);
    }
}