import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    @DisplayName("난수가 4이상일때 거리 증가")
    void moveTest() throws Exception {
        //given
        Car car = new Car("aaa");
        int randomNumber = 4;
        int moveCount = car.getMoveCount();

        //when
        car.move(randomNumber);

        //then
        assertThat(car.getMoveCount()).isEqualTo(moveCount + 1);
    }

    @Test
    @DisplayName("난수가 4미만일때 거리변화 없음")
    void moveTest2() throws Exception {
        //given
        Car car = new Car("aaa");
        int randomNumber = 2;
        int moveCount = car.getMoveCount();

        //when
        car.move(randomNumber);

        //then
        assertThat(car.getMoveCount()).isEqualTo(moveCount);
    }
}
