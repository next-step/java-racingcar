package racing.domain;

import static org.assertj.core.api.Assertions.*;
import org.junit.Test;
import racing.domain.RacingCar;


public class RacingCarTest {

    @Test
    public void 레이싱카_생성() {
        RacingCar car = new RacingCar("jinho");
        assertThat(car.getName()).isEqualTo("jinho");
        assertThat(car.getCurrentPosition()).isEqualTo(0);
    }

    @Test
    public void 레이싱_이동_조건_만족시_확인() {
        RacingCar car = new RacingCar("jinho");
        int move_condition = 4;
        car.move(move_condition);
        assertThat(car.getCurrentPosition()).isEqualTo(1);
    }

    @Test
    public void 레이싱_이동_조건_불만족시_확인() {
        RacingCar car = new RacingCar("jinho");
        int move_condition = 3;
        car.move(move_condition);
        assertThat(car.getCurrentPosition()).isEqualTo(0);
    }

    @Test
    public void 레이싱_3번중_모두_이동_확인() {
        RacingCar car = new RacingCar("jinho");
        int[] moveConditions = new int[] {4, 4, 4};
        for (int moveCondtion:moveConditions) {
            car.move(moveCondtion);
        }
        assertThat(car.getCurrentPosition()).isEqualTo(3);
    }

    @Test
    public void 레이싱_3번중_1번정지_이동_확인() {
        RacingCar car = new RacingCar("jinho");
        int[] moveConditions = new int[] {4, 1, 4};
        for (int moveCondtion:moveConditions) {
            car.move(moveCondtion);
        }
        assertThat(car.getCurrentPosition()).isEqualTo(2);
    }
}