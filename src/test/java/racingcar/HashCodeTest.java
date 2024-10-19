package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Position;

import static org.assertj.core.api.Assertions.assertThat;

public class HashCodeTest {

    private Car car;
    private Car car2;
    @BeforeEach
    void setUp(){
        car = new Car("ming", new Position(1), () -> false);
        car2 = new Car("ming", new Position(1), () -> false);
    }

    @Test
    void equals_테스트(){
        assertThat(car).isEqualTo(car2);
    }
    @Test
    void hashCode_테스트(){
        assertThat(car.hashCode()).isEqualTo(car2.hashCode());
    }

}
