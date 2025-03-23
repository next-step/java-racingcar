package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {
    public static final String MERCEDES = "benz";
    public static final String AUDI = "audi";
    private Car car;

    @BeforeEach
    void setUp() {
        this.car = new Car(new Name(MERCEDES), new Position());
    }

    @DisplayName("자동차의 위치를 한 칸 증가시킬 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {4, 9})
    void moveTest(int argument) {
        Car testCar = new Car(new Name(MERCEDES), new Position(2));

        Car sut = car.move(new FakeMovingStrategy(argument));

        assertThat(testCar).isEqualTo(sut);
    }

    @DisplayName("파라미터로 받는 숫자가 4 미만인 경우 자동차는 움직이지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 3})
    void notMoveTest(int argument) {
        Car testCar = new Car(new Name(MERCEDES), new Position(1));

        Car sut = car.move(new FakeMovingStrategy(argument));

        assertThat(sut).isEqualTo(testCar);
    }

    @DisplayName("자동차의 이름을 가져올 수 있다.")
    @Test
    void getCarNameTest() {
        assertThat(car.getName()).isEqualTo(new Name(MERCEDES));
    }

    @DisplayName("자동차의 위치를 가져 올 수 있다.")
    @Test
    void getPositionTest() {
        assertThat(car.getPosition()).isEqualTo(new Position());
    }

    @DisplayName("두 개의 Position중 큰 값을 반환 할 수 있다.")
    @Test
    void getBetterPositionTest() {
        Position sut = car.getBetterPosition(new Position(3));

        assertThat(sut).isEqualTo(new Position(3));
    }

    @DisplayName("Car의 Position이 가장 큰 값이라면 리스트에 넣고 반환한다.")
    @Test
    void addWinnerTest() {
        // given
        List<Car> winners = new ArrayList<>();
        Car car = new Car(new Name(AUDI), new Position(5));

        // when
        List<Car> sut = car.addWinner(new Position(5), winners);

        // then
        assertThat(sut).hasSize(1);
        assertThat(sut.get(0)).isEqualTo(car);
    }
}
