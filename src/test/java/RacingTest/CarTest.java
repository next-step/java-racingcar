package RacingTest;

import racing.Car;
import racing.Judgement;
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
        Assertions.assertThat(RandomUtils.generateRandomNumber(10)).isBetween(0, 9);
    }

    @Test
    @DisplayName(value = "랜덤 함수가 0~9 사이의 값이 나오는지 확인")
    void 차량_전진조건_테스트() {
        Assertions.assertThat(RandomUtils.generateRandomNumber(10)).isBetween(0, 9);
    }

    @Test
    @DisplayName(value = "랜덤 함수가 4 이상인 경우 true / 미만이면 false 인지 검증")
    void 차량_전진여부_테스트() {
        int randomNum = RandomUtils.generateRandomNumber(10);
        assertThat(randomNum >= Car.MOVE_THRESHOLD).isEqualTo(car.isMovable(randomNum));
    }

    @Test
    @DisplayName(value = "차량이 전진하는지 여부 확인")
    void 차량_전진_테스트() {
        car.move(RandomUtils.generateRandomNumber(10));
        assertThat("-".repeat(car.getDistance())).isIn("-", "");
    }

    @Test
    @DisplayName(value = "승자 테스트")
    void 승자_출력_테스트() {
        List<Car> cars = List.of(
                new Car("a"),
                new Car("b"),
                new Car("c")
        );
        cars.get(0).move(4);
        cars.get(1).move(4);
        cars.get(2).move(1);

        Judgement judgement = new Judgement();

        assertThat(judgement.getWinnerCars(cars)).isEqualTo(List.of(cars.get(0), cars.get(1)));
    }

    @Test
    @DisplayName(value = "차량 이름 5글자 넘어간 경우 에러 케이스")
    void 차량명_초과_테스트() {
        assertThatThrownBy(() -> {
            new Car("가나다라마바");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}