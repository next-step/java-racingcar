package racingCar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReadyTest {
    private String CAR_NAME;

    @BeforeEach
    void setUP() {
        CAR_NAME = "sung,ho,jun";
    }

    @Test
    @DisplayName("자동차 이름을 ,로 분리하는 테스트")
    void splitterTest() {
        // given
        Ready ready = new Ready();

        // when
        String[] expecte = {"sung","ho","jun"};
        String[] acual = ready.splitter(CAR_NAME);

        // then
        assertThat(acual).isEqualTo(expecte);
    }

    @ParameterizedTest
    @CsvSource( value = {"sung,True", "tomas,false","ho,true"})
    @DisplayName("자동차 이름 길이 제한 함수 테스트")
    void checkNameLengthTest(String name, boolean expected) {
        // given
        String testName = "sung";
        Ready ready = new Ready();

        // when
        boolean actual = ready.checkNameLength(name);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}
