package racingGame.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.assertThat;

class CarForwardRuleTest {

    @Mock
    private CarForwardRule carForwardRule;

    @ParameterizedTest
    @CsvSource(value = {"5:true", "2:false", "8:true", "3:false"}, delimiter = ':')
    @DisplayName("랜덤 숫자 생성 메소드를 재정의 함으로써 result() 메소드 테스트")
    void result(int randomNumber, boolean expected) {
        carForwardRule = new CarForwardRule() {
            @Override
            public int generateRandomNumber() {
                return randomNumber;
            }
        };

        assertThat(carForwardRule.result()).isEqualTo(expected);
    }
}