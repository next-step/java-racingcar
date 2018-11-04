package racinggame;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    Car car;

    @Before
    public void 자동차_셋팅(){
        car = new Car("pobi", 0);
        //car("crong", 0);
        //car("honux", 0);

    }

    @Test
    public void 자동차_이동() {
        car = new Car("pobi", 0){
            @Override
            protected boolean isPossibleMove() {
                return true;
            }
        };
        car.carMove(car);
        assertThat(car.getLocation()).isEqualTo(1);

    }

    @Test
    public void 자동차_정지() {
        car = new Car("pobi", 0){
            @Override
            protected boolean isPossibleMove() {
                return false;
            }
        };
        car.carMove(car);
        assertThat(car.getLocation()).isEqualTo(0);

    }

    @Test
    public void 자동차_생성여부() {
        car = new Car("pobi", 0);
        assertThat(car.getName()).isEqualTo("pobi");

    }
}