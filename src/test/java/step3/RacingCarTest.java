package step3;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import step2.Calculator;

public class RacingCarTest {
	
	Car car;
	Racing racing;
	
    @BeforeEach
    void setUp() {
        car = new Car();
    }

    @DisplayName("자동차 전진 테스트")
    @ParameterizedTest
    @ValueSource(ints = {4, 9})
    public void 전진_테스트(int number) {
        car.tryToMove(number);
        assertThat(car.getPosition()).isOne();
    }

    @DisplayName("자동차 정지 테스트")
    @ParameterizedTest
    @ValueSource(ints = {0, 3})
    public void 정지_테스트(int number) {
    	car.tryToMove(number);
    	assertThat(car.getPosition()).isZero();
    }
    
    @DisplayName("레이싱 경주 이벤트 발생 테스트(차량 숫자 예외)")
    @ParameterizedTest
    @CsvSource(value = {"1:1"}, delimiter = ':')
    public void 차량_예외_테스트(int cars, int rounds) {
        assertThatIllegalArgumentException().isThrownBy(()->{
        	racing = new Racing(cars, rounds);
        }).isInstanceOf(IllegalArgumentException.class);
    }
    
    @DisplayName("레이싱 경주 이벤트 발생 테스트(라운드 숫자 예외)")
    @ParameterizedTest
    @CsvSource(value = {"2:0"}, delimiter = ':')
    public void 라운드_예외_테스트(int cars, int rounds) {
        assertThatIllegalArgumentException().isThrownBy(()->{
        	racing = new Racing(cars, rounds);
        }).isInstanceOf(IllegalArgumentException.class);
    }
    
}
