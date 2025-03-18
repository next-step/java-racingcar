import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    Car car = new Car();

    @Test
    @DisplayName(value = "Random Number 생성 테스트")
    void generateRandomNumber() {
        assertThat(RandomUtils.generateRandomNumber(10)).isBetween(0, 9);
    }

    @Test
    @DisplayName(value = "랜덤 함수가 0~9 사이의 값이 나오는지 확인")
    void 차량_전진조건_테스트() {
        assertThat(RandomUtils.generateRandomNumber(10)).isBetween(0, 9);
    }

    @Test
    @DisplayName(value = "랜덤 함수가 4 이상인 경우 true / 미만이면 false 인지 검증")
    void 차량_전진여부_테스트() {
        int randomNum = RandomUtils.generateRandomNumber(10);
        assertThat(randomNum >= 4).isEqualTo(car.isMove(randomNum));
    }

    @Test
    @DisplayName(value = "차량이 전진하는지 여부 확인")
    void 차량_전진_테스트() {
        car.move(RandomUtils.generateRandomNumber(10));
        assertThat("-".repeat(car.getDistance())).isIn("-", "");
    }
}