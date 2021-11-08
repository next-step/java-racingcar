package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarListTest {

    @DisplayName("CarList 생성하고 int[]의 크기 같은지 확인")
    @Test
    public void carListLength() {
        int carCount = 3;
        CarList carList = new CarList(carCount);
        assertThat(carList.length()).isEqualTo(carCount);
    }

    @DisplayName("CarList의 move함수 반환 자료형은 int[]")
    @Test
    public void carListMove() {
        CarList carList = new CarList(3);
        assertThat(carList.move()).isInstanceOf(int[].class);
    }
}
