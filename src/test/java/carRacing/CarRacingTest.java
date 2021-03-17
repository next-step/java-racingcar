package carRacing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarRacingTest {
    final static String DELIMITER = ",";

    CarRacing carRacing;

    @ParameterizedTest
    @DisplayName("Create CarRacing Test - success")
    @ValueSource(strings = {"test,jbh,jbh1,java"})
    void createCarRacingTest(String input){
        carRacing = new CarRacing(input);
        assertThat(carRacing.getCars().size()).isEqualTo(input.split(DELIMITER).length);
        carRacing.getCars().forEach(car -> assertThat(car.getPosition()).isEqualTo(0));
    }

    @ParameterizedTest
    @DisplayName("Create CarRacing Test - fail")
    @ValueSource(strings = {"testname,test,fail"})
    void createCarRacingTest2(String input){
        assertThatIllegalArgumentException()
                .isThrownBy(()->carRacing = new CarRacing(input))
                .withMessage("자동차 이름은 5자를 초과할 수 없습니다.");
    }

    @ParameterizedTest
    @DisplayName("Start CarRacing Test - fail")
    @ValueSource(ints = {-3,0})
    void startCarRacingTest(int input){
        carRacing = new CarRacing("test1,test,fail");
        assertThatIllegalArgumentException()
                .isThrownBy(()->carRacing.startRacing(input))
                .withMessage("유효한 양의 정수를 입력하세요");
    }

}