package step3.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static step3.domain.Car.DEFAULT_POSITION;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    private Cars cars;
    private Car car1;
    private Car car2;
    private Car car3;

    @BeforeEach
    void setUp() {
         car1 = new Car();
         car2 = new Car();
         car3 = new Car();

         cars = new Cars(List.of(car1, car2, car3));
    }

    @Test
    void createTest() {
        Cars carsCreated = new Cars(List.of(new Car(), new Car(), new Car()));

        assertThat(carsCreated).isNotNull();
        assertThat(carsCreated.size()).isEqualTo(3);
    }

    @Test
    void Cars_안의_차들의_현재위치를_확인한다() {
        List<Integer> positions = cars.getPositions();

        assertThat(positions).containsExactly(DEFAULT_POSITION, DEFAULT_POSITION, DEFAULT_POSITION);
    }

    @Test
    void proceedTest() {
        cars.proceed();
        cars.proceed();

        List<Integer> positions = cars.getPositions();

        assertThat(positions).containsExactly(DEFAULT_POSITION +2, DEFAULT_POSITION +2, DEFAULT_POSITION +2);
    }

    @DisplayName("전진정책이 필요한 진행 시에 정책이 없으면 예외가 발생한다.")
    @Test
    void proceedWithNullPolicyTest() {
        assertThatThrownBy(() -> {
            cars.proceedWithPolicy(null);
        }).isInstanceOf(RuntimeException.class);
    }

}