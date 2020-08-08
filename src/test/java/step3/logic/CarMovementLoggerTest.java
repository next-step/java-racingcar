package step3.logic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarMovementLoggerTest {

    @Test
    @DisplayName("자동차 레이싱 기록이 잘 초기화 되었는지")
    void getCarMovementLog() {
        CarMovementLogger carMovementLogger = new CarMovementLogger();

        assertThat(carMovementLogger.getCarMovementLog()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차 레이싱 기록 확인")
    void makeCarMove() {
        CarMovementLogger carMovementLogger = new CarMovementLogger();
        carMovementLogger.makeCarMove(true);
        carMovementLogger.makeCarMove(false);
        carMovementLogger.makeCarMove(true);

        assertThat(carMovementLogger.getCarMovementLog()).isEqualTo(2);
    }
}