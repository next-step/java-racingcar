package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarsTest {

    @Test
    @DisplayName("자동차 생성")
    void create_new_car_list_size() {
        Cars cars = Cars.newCars(5);
        assertThat(cars.getCars().size()).isEqualTo(5);
        assertThat(
            Cars.newCars(5, new DefaultCarFactoryImpl())
                .getCars()
                .size()
        ).isEqualTo(5);
        assertThat(Cars.newCars(5, new DefaultCarFactoryImpl(), new DefaultMoveStrategy())
                       .getCars()
                       .size()
        ).isEqualTo(5);
    }

    @Test
    @DisplayName("자동차 0대 생성시 예외 발생")
    void create_new_car_list_size_0() {
        assertThatIllegalArgumentException().isThrownBy(() -> Cars.newCars(0));
    }

    @Test
    @DisplayName("최초 생성시 시작점은 0")
    void create_new_car_starting_point_is_0() {
        Cars cars = Cars.newCars(1);
        assertThat(cars.getCars().get(0).getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("모든 차량 +1 전진")
    void go_all_cars() {
        Cars cars = Cars.newCars(3, new MoveStrategy() {
            @Override
            public boolean isMove() {
                return true;
            }
        });
        Cars newCars = cars.startTurn();
        assertThat(newCars.getCars().get(0).getPosition()).isEqualTo(1);
        assertThat(newCars.getCars().get(1).getPosition()).isEqualTo(1);
        assertThat(newCars.getCars().get(2).getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("모든 차량 정지")
    void stop_all_cars() {
        Cars cars = Cars.newCars(3, new MoveStrategy() {
            @Override
            public boolean isMove() {
                return false;
            }
        });
        Cars newCars = cars.startTurn();
        assertThat(newCars.getCars().get(0).getPosition()).isEqualTo(0);
        assertThat(newCars.getCars().get(1).getPosition()).isEqualTo(0);
        assertThat(newCars.getCars().get(2).getPosition()).isEqualTo(0);
    }

}
