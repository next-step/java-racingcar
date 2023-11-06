package racingCar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GameNumberBoxTest {

    private final NumberBox numberBox = new GameNumberBox();

    @Test
    @DisplayName("음수 입력 시 에러")
    void invalidInput(){
        assertThatThrownBy(()->numberBox.getRandomInt(-1)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("랜덤숫자는 '입력 -1' 보다 항상 작거나 같다")
    void RandomNumber(){
        assertThat(numberBox.getRandomInt(10)).isLessThanOrEqualTo(9);
    }


}
