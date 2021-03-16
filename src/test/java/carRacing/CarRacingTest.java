package carRacing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarRacingTest {
    CarRacing carRacing;

    @ParameterizedTest
    @DisplayName("Create CarRacing Test - success")
    @ValueSource(ints = {1,3,6})
    void createCarRacingTest(int input){
        carRacing = new CarRacing(input);
        assertThat(carRacing.getCars().size()).isEqualTo(input);
        carRacing.getCars().forEach(car -> assertThat(car.getPosition()).isEqualTo(0));
    }

    @ParameterizedTest
    @DisplayName("Create CarRacing Test - fail")
    @ValueSource(ints = {-3,0})
    void createCarRacingTest2(int input){
        assertThatIllegalArgumentException()
                .isThrownBy(()->carRacing = new CarRacing(input))
                .withMessage("유효한 양의 정수를 입력하세요");
    }
    @ParameterizedTest
    @DisplayName("Start CarRacing Test - fail")
    @ValueSource(ints = {-3,0})
    void startCarRacingTest(int input){
        carRacing = new CarRacing(2);
        assertThatIllegalArgumentException()
                .isThrownBy(()->carRacing.startRacing(input))
                .withMessage("유효한 양의 정수를 입력하세요");
    }

}