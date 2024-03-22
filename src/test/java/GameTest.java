import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.InputMismatchException;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {
    private Game game = new Game();

    @Test
    @DisplayName("실행결과_검증")
    void 실행결과_검증(){
        String result = game.resultStr(new Car(5));
        assertThat(result).isEqualTo("-----");
    }

//    @Test
//    void exceptionTest() {
//        String input = "ddd";
//
//        try {
//            game.playGame(input, input);
//        } catch (InputMismatchException e) {
//            assertThat("유효하지 않은 입력입니다. 숫자만 입력하세요").isEqualTo(e.getMessage());
//        }
//    }
}
