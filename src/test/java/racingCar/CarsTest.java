package racingCar;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @Test
    void 자동차_이름_입력_테스트() {
        String names = "pobi,crong,honux";
        Cars cars = new Cars(names);
        assertThat(cars.getCars()).hasSize(3);
        assertThat(cars.getCars().get(0).getName()).isEqualTo("pobi");
        assertThat(cars.getCars().get(1).getName()).isEqualTo("crong");
        assertThat(cars.getCars().get(2).getName()).isEqualTo("honux");
    }

    @Test
    void 우승자_테스트() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car(3, "pobi"));
        carList.add(new Car(4, "crong"));
        carList.add(new Car(5, "honux"));
        Cars cars = new Cars(carList);

        List<String> winners = cars.getWinners();
        assertThat(winners).containsExactly("honux");
    }

    @Test
    void 우승자_2명이상_테스트() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car(5, "pobi"));
        carList.add(new Car(4, "crong"));
        carList.add(new Car(5, "honux"));
        Cars cars = new Cars(carList);

        List<String> winners = cars.getWinners();
        assertThat(winners).contains("pobi", "honux");
    }
}