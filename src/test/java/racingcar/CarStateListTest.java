package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarStateListTest {

    @DisplayName("자동차 상태 정보 리스트 객체 생성 테스팅")
    @Test
    void carStatListCreationTest() {
        int size = 3;
        String[] names = new String[]{"pobi", "tdd", "cleanCode"};

        Cars cars = Cars.createAllCars(names);

        CarStateList carStateList = CarStateList.makeCarStateList(cars.getStates());

        assertThat(carStateList.getStates()).hasSize(names.length);
    }
}