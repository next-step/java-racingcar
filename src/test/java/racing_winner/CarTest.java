package racing_winner;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    private Car car;

    @BeforeEach
    void setUp(){
        car = new Car("grandeur");
        car.tryMove(3);
    }

    @Test
    @DisplayName("tryMove가 성공했을경우, level값이 증가한다.")
    void tryMove() {
        Assertions.assertThat(car.getLevel()).isEqualTo(1);
    }

    @Test
    @DisplayName("차는 상태값 반환이 가능하다.")
    void getStatus() {
        Assertions.assertThat(car.getStatus()).isEqualTo("grandeur : -");
    }
}