package domain;

import static core.RandomMoveFactory.generateRandomOutOfTen;
import static domain.UserInput.isOverOne;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("도메인 패키지에 생성한 객체들의 테스트")
public class DomainLogicTest {

    @Test
    @DisplayName("자동차를 입력한 정수 대 만큼 생성한다.")
    void createCar() {
        Random random = new Random();
        int numberOfCars = random.nextInt(1000);
        List<Car> carList = Car.createCarList(numberOfCars);
        assertThat(carList).hasSize(numberOfCars);
    }

    @Test
    @DisplayName("자동차의 움직임을 입력한 숫자의 횟수만큼 시도해본다.")
    void moveCar() {
        Random random = new Random();
        int numberOfAttempts = random.nextInt(10);
        Car car = new Car(1);

        IntStream.range(0, numberOfAttempts)
                .forEach(i -> car.attemptMove());

        assertThat(car.getCurrentDistance())
                .isNotEqualTo("");

    }

    @Test
    @DisplayName("임의의 값을 생성한다.")
    void getRamDome() {
        int randomValue = generateRandomOutOfTen();

        assertThat(randomValue).isBetween(0, 10);
    }

    @ParameterizedTest(name = "User 의 입력값이 0 이거나 음수이면 에러표시 : {0} 일 때")
    @ValueSource(ints = {0, -1, -2, -3})
    void isNotOverOne(int element) {
        assertThatThrownBy(() -> isOverOne(element))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("0 이상의 정수만 입력 가능합니다.");

    }
}
