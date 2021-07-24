package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingTest {

    private Racing racing;

    @BeforeEach
    void setUp() {
        MessageBox messageBox = new MessageBox();
        racing = new Racing(messageBox);
    }

    @Test
    @DisplayName("자동차는 입력값의 , 에따라 생성된다.")
    public void createPayerBySplit() {
        List<Car> cars = racing.createPlayer("car1,car2,car3");

        assertThat(cars.size()).isEqualTo(3);
    }


    @Test
    @DisplayName("자동차의 이름은 5글자를 초과하면 예외가 발생된다.")
    public void createPayerNameLimit_check() {
        assertThatThrownBy(() -> racing.createPlayer("naming,para,you"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("자동차 이름은 5글자를 초과할수 없습니다.");
    }

    @Test
    @DisplayName("자동차는 최소 1대이상 아니면 예외가 발생된다.")
    public void createPayerAtListOne_check() {
        assertThatThrownBy(() -> racing.createPlayer(" "))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("자동차는 최소 1대 이상이어야 한다.");
    }


    @Test
    @DisplayName("랜덤함수는 0~9사이의 값을 가지고 있다.")
    public void randomValue_check() {
        int firstValue = 0;
        int lastValue = 10;

        int result1 = racing.randomValue();

        betweenCheck(result1, firstValue, lastValue);

        int result2 = racing.randomValue();


        betweenCheck(result2, firstValue, lastValue);
    }

    private void betweenCheck(int checkValue, int firstValue, int lastValue) {
        assertThat(checkValue).isGreaterThanOrEqualTo(firstValue).isLessThan(lastValue);
    }

    @ParameterizedTest
    @DisplayName("경주의 결과만큼 '-'로 반환된다.")
    @CsvSource(value = {"1,-","2,--","3,---","4,----","5,-----"})
    public void intResultToStringResult(int intResult, String stringResult){
        racing.createPlayer("car1,car2,car3");
        String racingResultByString = racing.getRacingResultByString(intResult);

        assertThat(racingResultByString).isEqualTo(stringResult);
    }

}
