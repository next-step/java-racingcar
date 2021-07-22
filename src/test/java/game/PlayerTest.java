package game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {

    @ParameterizedTest
    @DisplayName("입력받은 숫자가 4이상이면 증가하고 그렇지 않으면 정지한다.")
    @CsvSource(value = {"4,1","3,0","7,1"})
    public void playerMove(int randomValue, int moveValue) {
        Player player = new Player("car");
        int result = player.playToMove(randomValue);

        assertThat(result).isEqualTo(moveValue);
    }
}
