package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.Name;
import step3.exception.CarNameExceedException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class NameTest {

    private static final String EXCEPTION_NAME = "pobiiiii";
    private static final String EXCEPTION_MESSAGE = "자동차 이름은 5자를 초과할 수 없습니다";

    @Test
    @DisplayName("자동차 이름은 5자를 초과할 수 없다")
    public void 자동차_이름_초과() {
        assertThatExceptionOfType(CarNameExceedException.class)
            .isThrownBy(() -> {
                new Name(EXCEPTION_NAME);
            }).withMessageMatching(EXCEPTION_MESSAGE);
    }

}
