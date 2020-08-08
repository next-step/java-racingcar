<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 1a623a6... feat 전체 로직 구현
package step3.logic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;
<<<<<<< HEAD

class CarMovementTest {

    @RepeatedTest(10)
    @DisplayName("자동차 전진, 정지 확인 로직")
    void isCarGoingForward() {
        assertThat(CarMovement.isCarGoingForward()).isFalse();
    }
=======
import static org.junit.jupiter.api.Assertions.*;

class CarMovementTest {

>>>>>>> 4d321b2... feat 랜덤값 및 정지 전진 로직 구현
=======

class CarMovementTest {

    @RepeatedTest(10)
    @DisplayName("자동차 전진, 정지 확인 로직")
    void isCarGoingForward() {
        assertThat(CarMovement.isCarGoingForward()).isFalse();
    }
>>>>>>> 1a623a6... feat 전체 로직 구현
}