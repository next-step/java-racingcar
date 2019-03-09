package racing;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarTest {

    @Test
    public void 자동차달리기정보가져오기() {
        Car car = new Car();
        car.move(4);
        assertThat(car.getMoveList().size()).isEqualTo(4);
    }

    @Test
    public void 자동차가이번에움직였나() {
        Car car = new Car();
        assertThat(car.getMoveCount(4)).isEqualTo(0);
        assertThat(car.getMoveCount(5)).isEqualTo(1);
    }

    @Test
    public void 랜덤값가져오기() {
        Car car = new Car();
        assertThat(car.getRandomValue()).isLessThan(10);
        assertThat(car.getRandomValue()).isGreaterThanOrEqualTo(0);
    }

    @Test
    public void 자동차리스트가져오기() {
        List<Car> carList = RacingCarUtils.getCarList(3, 5);
        assertThat(carList.size()).isEqualTo(3);
    }

}