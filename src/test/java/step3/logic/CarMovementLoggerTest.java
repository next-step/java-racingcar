<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 1a623a6... feat 전체 로직 구현
package step3.logic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
<<<<<<< HEAD

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
=======
import static org.junit.jupiter.api.Assertions.*;

class CarMovementLoggerTest {

>>>>>>> a72fa8c... feat 전체 로직 구현
=======

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
>>>>>>> 1a623a6... feat 전체 로직 구현
}