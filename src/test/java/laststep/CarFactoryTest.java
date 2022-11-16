package laststep;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import laststep.domain.Car;
import laststep.domain.Cars;
import laststep.service.CarFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarFactoryTest {
    private CarFactory factory;

    @BeforeEach
    void beforeEach() {
        factory = new CarFactory();
    }

    @Test
    @DisplayName("중복 이름 입력 시 예외")
    void validateDuplicatedNameOfCars() {
        assertThatThrownBy(()-> factory.makeCars(List.of("pobi", "pobi", "java")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복되지 않는 이름을 입력해주세요");
    }

    @Test
    @DisplayName("자동차들 생성 확인")
    void makeCars() {
        Cars actual = factory.makeCars(List.of("pobi", "uuha", "java"));
        Cars expected = new Cars(List.of(
                new Car("pobi"),
                new Car("uuha"),
                new Car("java")
        ));

        assertThat(actual).isEqualTo(expected);
    }
}
