package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.util.Dice;

import static org.assertj.core.api.Assertions.assertThat;


@DisplayName("주사위 클래스 테스트")
class DiceTest {

    @Test
    @DisplayName("주사위를 던진 결과가 0에서 9사이인지 확인하는 테스트")
    void castDiceTest() {
        assertThat(Dice.cast()).isBetween(0, 9);
    }

    @Test
    @DisplayName("요청한 갯수만큼 주사위 결과의 count가 나오는지 테스트")
    void castDiceByCarCountTest () {
        int requestCount = 10;
        assertThat(requestCount).isEqualTo(Dice.castByCarCount(requestCount).size());
    }

}