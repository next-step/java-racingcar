package step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CarTest {

    @Test
    @DisplayName("car test")
    public void test(){
        //given
        Car car = new Car("test");

        //when
        car.run(4);
        car.run(4);
        car.run(3);

        //then
        assertThat(car.getCurrentStatus()).isEqualTo(2);
        assertThat(car.getOwner()).isEqualTo("test");
    }

    @Test
    @DisplayName("car owner name exception test")
    public void test2(){
        //given
        assertThatIllegalArgumentException().isThrownBy(()-> new Car("test_owner"));
    }
}