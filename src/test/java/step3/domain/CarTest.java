package step3.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private Car car ;

    @BeforeEach
    void setUp(){
        car = new Car();
    }
    @ParameterizedTest
    @DisplayName("자동차가 일정 수준이상 넘으면 움직이는지 확인")
    @CsvSource(value = { "1:0" , "2:0" , "3:0" , "4:1" , "5:1"} ,delimiter = ':')
    void getCarPosition(int moveCondition , int expected) {
        car.move(moveCondition);
        assertThat(car.getCarPosition()).isEqualTo(expected);
    }

}