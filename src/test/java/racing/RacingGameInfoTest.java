package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.Car;
import racing.domain.RacingGameInfo;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RacingGameInfoTest {

    @Test
    @DisplayName("자동차 이름은 5자를 초과할 수 없다")
    void carNameException() {
        assertDoesNotThrow(() -> RacingGameInfo.split("pobi,crong,honux"));

        assertThatThrownBy(() -> RacingGameInfo.split("pobi,crong,honuxx"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("자동차 이름은 쉼표(,)를 기준으로 구분한다")
    void carNameSeparator() {
        String[] result = RacingGameInfo.split("pobi,crong,honux");
        assertThat(result).contains("pobi","crong","honux");
    }

    @Test
    @DisplayName("입력된 이름에 공백이 있을 경우 제거한다")
    void removeWhiteSpace() {
        String[] result = RacingGameInfo.split("pob i");
        assertThat(result).contains("pobi");
    }

    @Test
    @DisplayName("자동차 이름이 5자이내인 경우 정상적으로 세팅되는지 확인")
    void getCarName() {
        assertEquals(new Car("pobis").getName(), "pobis");
    }
}