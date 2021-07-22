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

    @ParameterizedTest
    @DisplayName("이름을 입력하면 해당 이름이 반환된다.")
    @CsvSource(value = {"car1","car2","car3"})
    public void getPlayerName(String value){
        Player player = new Player(value);
        String playerName = player.getPlayerName();

        assertThat(playerName).isEqualTo(value);
    }
}
