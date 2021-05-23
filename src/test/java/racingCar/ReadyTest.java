package racingCar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ReadyTest {
    @Test
    @DisplayName("선수 목록 만들기")
    void TestCreatePlayerList() {
        // when
        Ready ready = new Ready();
        String name = "s,h,j";

        // given
        String[] expected = {"s","h","j"};
        String[] actual = ready.createPlayerList(name);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}
