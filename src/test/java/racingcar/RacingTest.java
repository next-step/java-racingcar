package racingcar;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {


    //움직인 조건에 대한 테스트 코드
    @Test
    public void 움직임_조건_4이상인_경우에만_움직임() {
        boolean result;
        result = RacingCar.isMoving(4);
        assertThat(result).isEqualTo(true);

        result = RacingCar.isMoving(6);
        assertThat(result).isEqualTo(true);

        result = RacingCar.isMoving(2);
        assertThat(result).isEqualTo(false);
    }

    @Test
    public void 랜덤_숫자_생성() {
       int random = Racing.generateRandomNum();
       assertThat(random).isBetween(0, 9);
    }

    @Test
    public void move_동작_테스트() {
        RacingCar car = new RacingCar();

        int result = car.move(8);
        assertThat(result).isEqualTo(1);

    }
}