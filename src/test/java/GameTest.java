import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {
    private Game game = new Game();

    @Test
    @DisplayName("실행결과_검증")
    void 실행결과_검증(){
        String result = game.resultStr(new Car(5));
        assertThat(result).isEqualTo("-----");
    }
}
