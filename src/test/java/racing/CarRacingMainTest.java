package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarRacingMainTest {
    

    @Test
    @DisplayName("스캐너로 받는 입력값이 숫자일경우 그값을 반환한다.")
    public void scannerValueToIntValue() {
        int result1 = CarRacingMain.intValueByScanner("3");
        int result2 = CarRacingMain.intValueByScanner("5");

        assertThat(result1).isEqualTo(3);
        assertThat(result2).isEqualTo(5);
    }

    @Test
    @DisplayName("입력받은 문자열을 숫자형태로 반환한다.")
    public void stringValueToIntValue() {
        int result1 = CarRacingMain.toInt("2");
        int result2 = CarRacingMain.toInt("5");

        assertThat(result1).isEqualTo(2);
        assertThat(result2).isEqualTo(5);
    }

    @Test
    @DisplayName("입력값에 숫자가 아닌 문자를 입력시 예외가 발생된다.")
    public void inputValue_notNumber_check() {
        assertThatThrownBy(() -> CarRacingMain.validByNumberCheck("D!2"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("해당 문자는 숫자만 사용 가능합니다.");
    }

    @Test
    @DisplayName("경주에 참가할 자동차 대수를 입력하면 대수만큼 자동차가 생성된다.")
    public void create_carModel() {
        List<CarModel> carModelList = CarRacingMain.createCarByNumber(4);

        assertThat(carModelList).extracting("carNumber").containsExactly(1, 2, 3, 4);
        assertThat(carModelList.size()).isEqualTo(4);
    }

    @Test
    @DisplayName("랜덤 숫자 함수를 실행하면 0이상 10미만의 숫자가 생성된다.")
    public void create_random_number() {
        int result = CarRacingMain.randomValue();

        assertThat(result).isGreaterThan(0).isLessThan(10);
    }

    @Test
    @DisplayName("랜덤 숫자가 4이상이면 경주에 사용되는 자동차가 전진한다.")
    public void racing_random_number_check() {
        boolean result1 = CarRacingMain.getRaceDistance(3);
        boolean result2 = CarRacingMain.getRaceDistance(8);

        assertThat(result1).isFalse();
        assertThat(result2).isTrue();
    }



}
