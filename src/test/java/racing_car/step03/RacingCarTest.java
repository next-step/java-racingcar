package racing_car.step03;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.Random;

import static org.assertj.core.api.Assertions.*;

class RacingCarTest {
    Random random;
    String[] cars;
    Race race;

    @BeforeEach
    void init() {
        random = new Random();
        cars = new String[3];
        race = new Race();
    }

    @Test
    @DisplayName("난수 생성 테스트")
    void 난수생성테스트() {
        for (int i = 0; i < 5; i++) {
           assertThat(race.generateRandomNumber()).isLessThan(10);
        }
    }

    @ParameterizedTest
    @DisplayName("random 값이 4이상일 때 전진하는 테스트")
    @CsvSource(value = {"3:false", "4:true", "2:false", "6:true", "1:false"}, delimiter = ':')
    void 전진(int number, boolean move) {
        Assertions.assertThat(race.move(number)).isEqualTo(move);
    }

//    @Test
//    @DisplayName("자동차의 상태 화면에 출력")
//    void 자동차의상태() {
//        Arrays.fill(cars, " ");
//        race.execute(cars);
//        for (String car : cars) {
//            System.out.println(car);
//        }
//    }

    @Test
    @DisplayName("자동차와 시도 회 수 입력 값이 0이하 일 때 예외 처리 하는 테스트")
    void 입력값테스트() {
        assertThatThrownBy(() ->
                Validation.inputValidation(0, -1)).isInstanceOf(IllegalArgumentException.class);
    }
}