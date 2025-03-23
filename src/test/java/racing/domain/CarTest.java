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
    private static final int INIT_POSITION = 1;
    private Car car;

    @BeforeEach
    void setUp() {
        this.car = new Car(createMercedesCarName(), INIT_POSITION);
    }

    @DisplayName("자동차의 위치를 한 칸 증가시킬 수 있다.")
    @ValueSource(ints = {4, 9})
    void carMovedTest(int argument) {
        Car sut = car.move(new FakeMovingStrategy(argument));

        assertThat(sut.getPosition()).isEqualTo(2);
    }

    @DisplayName("파라미터로 받는 숫자가 4 미만인 경우 자동차는 움직이지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 3})
    void carNotMovedTest(int argument) {
        Car sut = car.move(new FakeMovingStrategy(argument));

        assertThat(sut.getPosition()).isEqualTo(1);
    }

    @DisplayName("자동차의 이름을 가져올 수 있다.")
    @Test
    void getCarNameTest() {
        assertThat(car.getName()).isEqualTo(createMercedesCarName());
    }

    @DisplayName("자동차의 현재 위치를 가져 올 수 있다.")
    @Test
    void getPositionTest() {
        assertThat(car.getPosition()).isEqualTo(INIT_POSITION);
    }

    @DisplayName("position이 가장 큰 값을 반환 할 수 있다.")
    @Test
    void maxTest() {
        // given
        Car car = new Car(createMercedesCarName(), 4);

        // when
        int sut = car.max(3);

        // then
        assertThat(sut).isEqualTo(4);
    }

    @DisplayName("max값과 자동차의 position이 동일한지 검사할 수 있다.")
    @Test
    void addWinner() {
        // given
        List<Car> winners = new ArrayList<>();
        Car car = new Car(createMercedesCarName(), 4);

        // when
        List<Car> sut = car.addWinner(4, winners);

        // then
        assertThat(sut).hasSize(1);
        assertThat(sut.get(0)).isEqualTo(car);
    }

    private CarName createMercedesCarName() {
        return new CarName(MERCEDES);
    }
}
