package racing.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import racing.model.move.RandomMoveStrategy;
import racing.view.InputView;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CarsTest {

    @DisplayName("이름으로 자동차 생성")
    @ParameterizedTest
    @ValueSource(strings = {"test1,test2,test3"})
    void 자동차이름_콤마로구분해서_입력(String input) {
        String[] names = InputView.split(input);
        Cars cars = new Cars(names);

        assertThat(cars.getCars()).hasSize(names.length);
    }

    @DisplayName("우승자는 한명 이상일 수 있다.")
    @Test
    void 우승자_한명이상() {

        Car car1 = new Car("car1", 10, new RandomMoveStrategy());
        Car car2 = new Car("car2", 10, new RandomMoveStrategy());

        Cars cars = new Cars(new ArrayList<>());

        cars.getCars().add(car1);
        cars.getCars().add(car2);

        List<Car> winners = cars.findWinners();

        assertThat(winners.size()).isEqualTo(2);

    }
}
