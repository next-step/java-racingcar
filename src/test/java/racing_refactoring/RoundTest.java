package racing_refactoring;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing_refactoring.domain.Round;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RoundTest {

    @Test
    @DisplayName("경주 횟수 생성 예외 테스트")
    void setRoundException(){
        assertThatThrownBy(
                () -> new Round(0)
        ).isInstanceOf(IllegalArgumentException.class);
    }


}
