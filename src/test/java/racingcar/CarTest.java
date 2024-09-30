package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private Car car;

    @BeforeEach
    void setUp(){
        car = new Car(new MockRandom());
    }

    @Test
    @DisplayName("랜덤 값이 4 미만일 경우, 상태가 변하지 않아야 한다.")
    void 랜덤값_4미만_멈춤(){
        MockRandom.setNextInt(3);

        String prevStatus = car.getStatus();
        car.run();

        assertThat(car.getStatus()).isEqualTo(prevStatus);
    }

    @Test
    @DisplayName("랜덤 값이 4 미만일 경우, 상태가 변해야 하고, 상태에 -가 추가되어야 한다.")
    void 랜덤값_4이상_전진(){
        MockRandom.setNextInt(8);

        String prevStatus = car.getStatus();
        car.run();

        assertThat(car.getStatus()).isNotEqualTo(prevStatus);
        assertThat(car.getStatus()).isEqualTo("-");
    }

    @Test
    @DisplayName("0 ~ 9 사이의 랜덤값을 생성한다.")
    void 랜덤값_생성() {
        assertThat(car.generateRandomNumber()).isBetween(0, 9);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:false", "3:false", "4:true", "9:true"}, delimiter = ':')
    @DisplayName("4 이상의 숫자일 때 true를 반환한다.")
    void 숫자_4이상_조건_확인(int number, boolean expected) {
        assertThat(car.checkGreaterThanOrEqualToMinimumValue(number)).isEqualTo(expected);
    }
}
