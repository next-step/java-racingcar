package step3;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RacingCarTest {
	
	Car car;
	
    @BeforeEach
    void setUp() {
        car = new Car();
    }

    @DisplayName("자동차 전진 테스트")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    public void 전진_유효성_테스트(int number) {
        car.tryToMove(number);
        assertThat(car.getPosition()).isOne();
    }

    @DisplayName("자동차 전진 예외 테스트")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    public void 전진_예외_테스트(int number) {
        assertThatIllegalArgumentException().isThrownBy(()->{
        	car.tryToMove(number);
        }).isInstanceOf(IllegalArgumentException.class);
    }
    
}
