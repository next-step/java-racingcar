package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.Car;
import step3.utils.CarFactory;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarFactoryTest { //Factory 용도 : 생성

    @DisplayName("자동차 이름 생성")
    @Test
    void create() {
        List<Car> cars = CarFactory.create("crong, pobi");
        assertThat(cars).hasSize(2);
//        assertThat(cars).containsExactly(new Car("crong", position), new Car("pobi", position));
    }

}
