package step5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step5.domain.Car;
import step5.domain.Cars;
import step5.domain.GenerateNumber;
import step5.domain.RandomGenerate;

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
        car.move(new RandomGenerate(){
            @Override
            public int moreThenFour() {
                return super.moreThenFour();
            }
        });
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("전진하지않는 테스트")
    @Test
    void 전진_X() {
        Car car = new Car("qq",0);
        car.move(new RandomGenerate(){
            @Override
            public int lessThenFour() {
                return super.lessThenFour();
            }
        });
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("우승자 구하기")
    @Test
    public void 우승자() {
        String carName = "poby,byby,ruby";
        Cars carList = new Cars(carName);



        //assertThat(carList.findWinner()).isEqualTo(Arrays.asList(poby,byby));
    }
}
