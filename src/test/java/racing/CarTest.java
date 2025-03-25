package racing;

import racing.domain.Car;
import racing.domain.Cars;
import racing.domain.Judgement;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.utils.RandomUtils;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    Car car = new Car();

    @Test
    @DisplayName(value = "Random Number 생성 테스트")
    void generateRandomNumber() {
        Assertions.assertThat(RandomUtils.generateRandomNumber()).isBetween(0, 9);
    }

    @Test
    @DisplayName(value = "랜덤 함수가 0~9 사이의 값이 나오는지 확인")
    void 차량_전진조건_테스트() {
        Assertions.assertThat(RandomUtils.generateRandomNumber()).isBetween(0, 9);
    }

    @Test
    @DisplayName(value = "랜덤 함수가 4 이상인 경우 true / 미만이면 false 인지 검증")
    void 차량_전진여부_테스트() {
        int randomNum = RandomUtils.generateRandomNumber();
        assertThat(randomNum >= Car.MOVE_THRESHOLD).isEqualTo(car.isMovable(randomNum));
    }

    @Test
    @DisplayName(value = "차량이 전진하는지 여부 확인")
    void 차량_전진_테스트() {
        car.move(RandomUtils.generateRandomNumber());
        assertThat("-".repeat(car.getPosition())).isIn("-", "");
    }

    @Test
    @DisplayName(value = "차량 이름 5글자 넘어간 경우 에러 케이스")
    void 차량명_초과_테스트() {
        assertThatThrownBy(() -> {
            new Car("가나다라마바");
        }).isInstanceOf(IllegalArgumentException.class);
    }

}