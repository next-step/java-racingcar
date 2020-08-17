package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    @DisplayName("move 테스트")
    public void moveTest(){
        //given
        Car car = new Car();

        //when
        car.run(4);
        car.run(4);
        car.run(3);

        //then
        assertThat(car.getStatus()).isEqualTo(2);
    }
}