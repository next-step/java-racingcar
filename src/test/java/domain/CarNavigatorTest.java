package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarNavigatorTest {

    @DisplayName("0 이상 10 미만 임의의 수를 생성한다.")
    @Test
    public void shouldReturnRandomNumber() {
        //given
        int randomNum = CarNavigator.getRandomNumber();

        assertThat(randomNum).isGreaterThan(0);
        assertThat(randomNum).isLessThan(10);
    }

    @DisplayName("randomNumber를 생성해 4 이상이면 참을 반환한다")
    @Test
    public void shouldReturnTrue_whenRandomNumberIsAboveStandard() {

        //given
        int randomNum = CarNavigator.getRandomNumber();
        int standard = 4;

        //when
        boolean coin = CarNavigator.flipCoin(randomNum);

        //then
        if (randomNum >= standard) {
            assertThat(coin).isTrue();
        }
    }

    @DisplayName("randomNumber를 생성해 4 미만이면 거짓을 반환한다")
    @Test
    public void shouldReturnFalse_whenRandomNumberIsBelowStandard() {
        //given
        int randomNum = CarNavigator.getRandomNumber();
        int standard = 4;

        //when
        boolean coin = CarNavigator.flipCoin(randomNum);

        //then
        if (randomNum < standard) {
            assertThat(coin).isFalse();
        }
    }

}