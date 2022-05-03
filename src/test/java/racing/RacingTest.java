package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingTest {
    private static final int INITIAL_POSITION = 1;
    private Cars cars;

    @BeforeEach
    private void setup() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("car1", INITIAL_POSITION));
        carList.add(new Car("car2", INITIAL_POSITION));
        carList.add(new Car("car3", INITIAL_POSITION));
        cars = new Cars(carList);
    }

    @DisplayName("입력받은 자동차 값이 blank 이거나 한개, moveCount가 0 이하 일 경우 예외")
    @ParameterizedTest
    @CsvSource(value = {":5", " :5", "car1:5", "car1,car2:0"}, delimiter = ':')
    void startRacing_validationInput(String inputNames, int moveCount) {
        assertThatThrownBy(() -> Racing.startRacing(inputNames, moveCount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 받은 글자를 , 기준으로 나누고 공백은 trim")
    @ParameterizedTest
    @CsvSource(value = {" car1,car2 , car3 :5:4"}, delimiter = ':')
    void startRacing_trimInputNames(String inputNames, int moveCount, int expected) {
        Cars cars = Racing.startRacing(inputNames, moveCount);
        for (Car car : cars.getCars()) {
            assertThat(car.getName()).hasSize(expected);
        }
    }

    @DisplayName("입력 받은 글자 각각이 5글자 이하인지 확인")
    @ParameterizedTest
    @CsvSource(value = {"car1,Overthe5wordsCarName:5"}, delimiter = ':')
    void startRacing_inputIsNotOverFive(String inputNames, int moveCount) {
        assertThatThrownBy(() -> Racing.startRacing(inputNames, moveCount))
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }

    @DisplayName("입력 받은 자동차 수 만큼 list 크기 생성")
    @ParameterizedTest
    @CsvSource(value = {"car1,car2:5:2", "car1,car2,car3:5:3"}, delimiter = ':')
    void startRacing_carsSize(String inputNames, int moveCount, int expected) {
        Cars cars = Racing.startRacing(inputNames, moveCount);
        assertThat(cars.getCars()).hasSize(expected);
    }

    @DisplayName("random 값으로 만들어져서 0 또는 1의 값을 가진다.")
    @Test
    void racing_move() {
        Cars movedCar = Racing.racing(cars);
        for (Car car : movedCar.getCars()) {
            assertThat(car.getPosition()).isBetween(INITIAL_POSITION, INITIAL_POSITION + 1);
        }
    }
}
