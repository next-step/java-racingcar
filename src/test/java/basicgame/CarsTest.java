package basicgame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    Cars cars;

    @BeforeEach
    void init(){
        cars = new Cars();
    }

    @Test
    @DisplayName("Car 개수에 맞게 생성 테스트 Success")
    void initCarTestSuccess() {
        var expectedCarCount = 3;

        cars.initCar(expectedCarCount);

        assertThat(cars.carsSize()).isEqualTo(expectedCarCount);
    }

    @Test
    @DisplayName("Car 가져오는지와 체크 테스트 Success")
    void getCarsTestSuccess() {
        var expectedCarCount = 3;

        cars.initCar(expectedCarCount);
        var actualList = cars.getCars();

        assertThat(actualList.size()).isEqualTo(expectedCarCount);
    }
}