package racingCar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ReadyTest {
    private String CAR_NAME;

    @BeforeEach
    void setUP() {
        CAR_NAME = "ssung,ho,jun";
    }

    @Test
    @DisplayName("자동차 이름을 ,로 분리하는 테스트")
    void splitterTest() {
        // given
        Ready ready = new Ready();

        // when
        String[] expecte = {"ssung","ho","jun"};
        String[] acual = ready.splitter(CAR_NAME);

        // then
        assertThat(acual).isEqualTo(expecte);
    }

    @Test
    @DisplayName("자동차 이름 길이 제한 함수 테스트")
    void checkNameLengthTest() {
        // given
        String testName = "ssung";
        Ready ready = new Ready();
    }
}
