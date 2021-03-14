package step5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step5.domain.Car;
import step5.domain.Cars;

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
        Car car = new Car("qq",0) {
            @Override
            protected int generateRandomValue() {
                return 4;
            }
        };
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("전진하지않는 테스트")
    @Test
    void 전진_X() {
        Car car = new Car("qq",0) {
            @Override
            protected int generateRandomValue() {
                return 3;
            }
        };
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("우승자 구하기")
    @Test
    public void 우승자() {
        Car poby = new Car("poby",2);
        Car byby = new Car("byby",2);
        Car ruby = new Car("ruby",1);

        Cars carList = new Cars(Arrays.asList(poby, byby, ruby));
        assertThat(carList.findWinner()).isEqualTo(Arrays.asList(poby,byby));
    }
}
