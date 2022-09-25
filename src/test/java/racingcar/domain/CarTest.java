package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    @DisplayName("랜덤숫자가 4일때 move")
    void car_move_test(){
        Car car = new Car(){
              @Override
              protected int generateRandomNumber(){
                  return 4;
             }
        };
        car.move();
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("랜덤숫자가 2일때 stop")
    void car_not_move_test(){
        Car car = new Car(){
            @Override
            protected int generateRandomNumber(){
                return 2;
            }
        };
        car.move();
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
