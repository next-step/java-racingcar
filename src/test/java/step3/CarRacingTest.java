package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import step3.study.domain.Car;
import step3.study.domain.RequestRacingDTO;
import step3.study.util.RacingUtil;
import step3.study.util.Validator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CarRacingTest {
    @ParameterizedTest
    @CsvSource(value = {"a,a","b,b","n,4"})
    @DisplayName("숫자형식이 아닌 입력 테스트")
    void wrongNumberCheckTest(String carCount, String tryCount) {
        assertThatExceptionOfType(NumberFormatException.class).isThrownBy(() -> {
            RequestRacingDTO requestRacingDTO = new RequestRacingDTO(carCount,tryCount);
        }).withMessage("숫자형식이 아닙니다.");
    }


    @ParameterizedTest
    @CsvSource(value = {"1,3,1","2,2,2,","3,3,3"})
    @DisplayName("자동차 대수 생성 테스트")
    void createCarsTest(String carCount, String tryCount, int size) {
        RequestRacingDTO requestRacingDTO = new RequestRacingDTO(carCount,tryCount);
        List<Car> cars = Car.ofList(requestRacingDTO);
        assertThat(cars.size()).isEqualTo(size);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,''","6,'-'","3,''"})
    @DisplayName("4이상인 숫자가 들어오면 자동차는 이동한다.")
    void moveCarTest(int randomNumber, String distance){
        Car car = new Car();
        car.move(randomNumber);
        assertThat(car.getRecodeDistance().get(0)).isEqualTo(distance);
    }

}
