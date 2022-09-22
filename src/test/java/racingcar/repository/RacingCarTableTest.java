package racingcar.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.CarFactory;
import racingcar.domain.MoveStrategy;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTableTest {

    RacingCarTable carTable;

    @BeforeEach
    void setUp() {
        carTable = new RacingCarTable();
    }

    @DisplayName("Car 저장")
    @Test
    void save() {
        Car carA = new Car("testA");
        Car carB = new Car("testB");

        carTable.save(carA);
        carTable.save(carB);

        int size = carTable.findAll()
                            .size();
        assertThat(size).isEqualTo(2);
    }

    @DisplayName("Cars 저장")
    @Test
    void saveAll() {
        carTable.saveAll(CarFactory.createCars("noose,pobi,honux"));

        int size = carTable.findAll()
                            .size();
        assertThat(size).isEqualTo(3);
    }

    @DisplayName("불러온 데이터에 수정을 해도 테이블에 저장된 데이터는 변경되지 않는다.")
    @Test
    void findAll() {
        carTable.saveAll(CarFactory.createCars("noose,pobi,honux"));

        Car carA = carTable.findAll().getElements().get(0);
        MoveStrategy forward = () -> true;
        carA.move(forward);
        carA.move(forward);

        Car carB = carTable.findAll().getElements().get(0);

        assertThat(carB.positionValue()).isEqualTo(1);
    }
}