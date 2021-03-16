package step5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step5.domain.*;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class CarPositionTest {

    Car car;
    @BeforeEach
    public void before() {
        car = new Car("poby", 2);
    }

    @DisplayName("전진 잘 되는지 테스트")
    @Test
    void 전진_O() {
        Car car = new Car("qq",0);
        car.move(new FakeSuccessPolicy());
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("전진하지않는 테스트")
    @Test
    void 전진_X() {
        Car car = new Car("qq",0);
        car.move(new FakeFailPolicy());
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("우승자 구하기")
    @Test
    public void 우승자() {
        Car car1 = new Car("car1",2);
        Car car2 = new Car("car2",3);
        Car car3 = new Car("car3",4);
        Cars carList = new Cars(Arrays.asList(car1,car2,car3));

        assertThat(carList.finalWinner()).isEqualTo(Arrays.asList(car3));
    }
}
