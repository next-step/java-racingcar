package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    @DisplayName("N대의 자동차를 생성할 수 있다.")
    public void makeCars_requiredNumbers_makeSuccess() {
        int k = new Random().nextInt(15);
        Racing racing = new Racing();

        List<Car> madeCarList = racing.makeCars(k);

        assertThat(madeCarList.size()).isEqualTo(k);
    }

    @ParameterizedTest
    @DisplayName("전진하는 조건을 규칙에 맞게 생성할 수 있다.")
    @CsvSource(value = {"0:false", "3:false", "4:true", "9:true"}, delimiter = ':')
    public void judgeForth_rule_makeSuccess(int input, boolean expected){
        Car car = new Car();

        assertThat(car.judgeForth(input)).isEqualTo(expected);
    }

    @DisplayName("이동거리만큼 이동할 수 있다.")
    @Test
    public void move_instance_togo() {
        Car car = new Car();

        car.move(0);
        car.move(4);
        car.move(5);

        assertThat(car.nowPosition()).isEqualTo(2);
    }

    @DisplayName("랜덤 숫자 생성기를 통해 얻은 값으로 실제 이동하기")
    @Test
    public void move_getRandomValue_togo() {
        int totalMoveInstance = 0;
        RandomValue randomValue = new RandomValue();
        Car car = new Car();

        for (int i = 0; i < 10; i++) {
            int degree = randomValue.getValue();
            if (car.judgeForth(degree)) {
                totalMoveInstance++;
                car.move(degree);
            }
        }

        assertThat(car.nowPosition()).isEqualTo(totalMoveInstance);

    }

}