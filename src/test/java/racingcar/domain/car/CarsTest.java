package racingcar.domain.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {

    private Cars cars;

    @BeforeEach
    void init() {
        List<Car> testCars = Arrays.asList(new Car("엄태권", 0), new Car("OWEN", 0), new Car("TEST", 0));
        this.cars = new Cars(testCars);
    }

    @Test
    @DisplayName("생성한 Car의 갯수만큼 Cars에 생성된 carList에 추가된다.")
    void createCars() {
        assertThat(this.cars.getCars()).hasSize(3);
    }

    @Test
    @DisplayName("쉼표(,)로 구분된 3개의 이름을 입력하면 3개의 자동차가 생성된다.")
    void createCars_쉼표구분이름() {
        String[] inputCarNames = new String[]{"엄태권", "OWEN", "서버마법사"};

        Cars cars = new Cars(inputCarNames);

        assertThat(cars.getCars()).hasSize(3);
    }

    @Test
    @DisplayName("쉼표(,)로 구분된 3개의 이름 가운데 비어있는 이름이 있다면 자동차가 생성되지 않는다.")
    void createCars_중간에비어있는이름() {
        String[] inputCarNames = new String[]{"엄태권", "", "서버마법사"};

        assertThatThrownBy(() -> new Cars(inputCarNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 비어있을 수 없습니다.");
    }


    @Test
    @DisplayName("랜덤한 숫자중 4이상의 숫자가 나오면 자동차가 1칸 움직인다.")
    void moveCars_movable() {
        this.cars.move(() -> true);

        List<Car> carList = this.cars.getCars();
        boolean allMatchResult = carList.stream().allMatch(car -> car.getPosition() == 1);

        assertThat(allMatchResult).isTrue();
    }

    @Test
    @DisplayName("랜덤한 숫자중 3이하의 숫자가 나오면 자동차가 움직이지 않는다.")
    void moveCars_immovable() {
        this.cars.move(() -> false);

        List<Car> carList = this.cars.getCars();
        boolean allMatchResult = carList.stream().allMatch(car -> car.getPosition() == 0);

        assertThat(allMatchResult).isTrue();
    }

    @Test
    @DisplayName("get으로 가져온 불변 CarList를 clear 할 경우 오류가 발생한다.")
    void cleanCars() {
        List<Car> carList = this.cars.getCars();

        assertThatThrownBy(carList::clear)
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    @DisplayName("경기중 가장 많은 위치를 움직인 자동차의 이름들을 반환한다.")
    void findWinners() {
        List<Car> testCars = Arrays.asList(new Car("엄태권", 1), new Car("OWEN", 3), new Car("TEST", 3));
        Cars cars = new Cars(testCars);

        assertThat(cars.getWinners()).contains("TEST", "OWEN");
    }
}