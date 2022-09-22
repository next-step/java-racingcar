package racingcar.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.CarFactory;

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
        Car carA = new Car();
        Car carB = new Car();

        carTable.save(carA);
        carTable.save(carB);

        int size = carTable.findAll()
                            .size();
        assertThat(size).isEqualTo(2);
    }

    @DisplayName("Cars 저장")
    @Test
    void saveAll() {
        carTable.saveAll(CarFactory.createCars(3));

        int size = carTable.findAll()
                            .size();
        assertThat(size).isEqualTo(3);
    }

    @DisplayName("불러온 데이터에 수정을 해도 테이블에 저장된 데이터는 변경되지 않는다.")
    @Test
    void findAll() {
        carTable.saveAll(CarFactory.createCars(1));

        Car carA = carTable.findAll().getCars().get(0);
        carA.move(() -> true);
        carA.move(() -> true);

        Car carB = carTable.findAll().getCars().get(0);

        assertThat(carB.position()).isEqualTo(1);
    }
}