package step4.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class CarMovingTest {

    @Test
    @DisplayName("5이상의 값을 얻으면 차는 이동한다.")
    void getMoreThan_minimalNumber_thenCarMoving() {
        CarMoving carMoving = new CarMoving();
        carMoving.move(new MovalbeNumberGenerator());

        Assertions.assertThat(carMoving).extracting("distance").isEqualTo(1);
    }

    @Test
    @DisplayName("5미만의 값을 얻으면 차는 이동하지 않는다.")
    void getLessThen_minimalNumber_thenCarNotMoving() {
        CarMoving carMoving = new CarMoving();
        carMoving.move(new NotMovableNumberGenerator());

        Assertions.assertThat(carMoving).extracting("distance").isEqualTo(0);
    }

    @Test
    @DisplayName("5이상의 값을 얻으면 기존의 이동거리보다 한칸 더 이동한다.")
    void getMoreThan_minimalNumber_thenCarMove() {
        CarMoving carMoving = new CarMoving(1);
        carMoving.move(new MovalbeNumberGenerator());

        Assertions.assertThat(carMoving).extracting("distance").isEqualTo(2);
    }

    @Test
    @DisplayName("5이상의 값을 얻으면 기존의 이동거리보다 한칸 더 이동한다.")
    void getLessThan_minimalNumber_thenNotCarMove() {
        CarMoving carMoving = new CarMoving(1);
        carMoving.move(new NotMovableNumberGenerator());

        Assertions.assertThat(carMoving).extracting("distance").isEqualTo(1);
    }

    public static class MovalbeNumberGenerator implements NumberGenerator {
        @Override
        public int generate() {
            return 5;
        }
    }

    public static class NotMovableNumberGenerator implements NumberGenerator {

        @Override
        public int generate() {
            return 4;
        }
    }

}