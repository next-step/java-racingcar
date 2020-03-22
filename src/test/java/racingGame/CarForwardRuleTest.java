package racingGame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import racingGame.game.CarForwardRule;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CarForwardRuleTest {

    @Mock
    private CarForwardRule carForwardRule;
    private FakeCarForwardRule fakeCarForwardRule;

    @BeforeEach
    void setUp() {
        carForwardRule = mock(CarForwardRule.class);
        assertThat(carForwardRule).isNotNull();
        fakeCarForwardRule = new FakeCarForwardRule();
    }

    @ParameterizedTest
    @CsvSource(value = {"5:true", "2:false", "8:true", "3:false"}, delimiter = ':')
    @DisplayName("Mock 객체로 랜덤 값을 받고 자동차가 전진가능한 여부를 판단하는 기능 구현")
    void init(int input, boolean expected) {
        when(carForwardRule.generateRandomNumber()).thenReturn(input);
        when(carForwardRule.result()).thenReturn(expected);

        assertThat(carForwardRule.result()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"2:false", "4:true", "9:true", "3:false"}, delimiter = ':')
    @DisplayName("fake 객체로 랜덤 값을 받고 자동차가 전진가능한 여부를 판단하는 기능 구현")
    void fake_init(int input, boolean expected) {
        fakeCarForwardRule.injectionRandomNumber(input);

        assertThat(fakeCarForwardRule.result()).isEqualTo(expected);
    }
}