package step2.game.domain;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step2.game.domain.CarName;
import step2.game.domain.Cars;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CarsTest {
    private List<CarName> carNames = new ArrayList<>();

    @BeforeEach
    void setUp() {
        carNames.add(new CarName("pobi"));
        carNames.add(new CarName("crong"));
        carNames.add(new CarName("honux"));
    }

    @Test
    @DisplayName("자동차 생성")
    void create_new_car_list_size() {
        Cars cars = Cars.newCars(carNames);
        assertThat(cars.getCars().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("자동차 0대 생성시 예외 발생")
    void create_new_car_list_size_0() {
        assertThatIllegalArgumentException().isThrownBy(() -> Cars.newCars(new ArrayList<>()));
    }

    @Test
    @DisplayName("최초 생성시 시작점은 0")
    void create_new_car_starting_point_is_0() {
        Cars cars = Cars.newCars(carNames);
        assertThat(cars.getCars().get(0).getPosition()).isEqualTo(0);
    }

}
