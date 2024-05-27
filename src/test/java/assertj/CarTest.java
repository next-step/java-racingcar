package assertj;

import Model.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class CarTest {
    private Car car;

    @BeforeEach
    public void setUp() {
        car = new Car("TestCar");
    }
    //생성자 사용하여 제대로 초기화하였는지 확인
    @Test
    public void testCarInitialization() {
        assertThat(car.getName()).isEqualTo("TestCar");
        assertThat(car.getDistance()).isEqualTo(0);
    }
    //4보다 작은 수에서 움직이는지 확인
    @Test
    public void testMoveWithNumberLessThan4() {
        car.move(3);
        assertThat(car.getDistance()).isEqualTo(0);
    }
    //4이상의 수에서 움직이는지 확인
    @Test
    public void testMoveWithNumberGreaterThanOrEqualTo4() {
        car.move(4);
        assertThat(car.getDistance()).isEqualTo(1);

        car.move(5);
        assertThat(car.getDistance()).isEqualTo(2);
    }
    //distance 크기만큼 "-"가 제대로 출력되는지 확인
    @Test
    public void testToString() {
        car.setDistance(3);
        assertThat(car.toString()).isEqualTo("TestCar : ---");
    }

}
