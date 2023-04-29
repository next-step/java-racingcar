package racing.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import racing.model.move.RandomMoveStrategy;
import racing.util.NameUtil;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CarsTest {

    @DisplayName("입력한 숫자만큼 자동차 생성")
    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5})
    void createCarsTest(int number) {
        Cars cars = new Cars(number, new RandomMoveStrategy());

        assertThat(cars.getCars()).hasSize(number);
    }

    @DisplayName("이름으로 자동차 생성")
    @ParameterizedTest
    @ValueSource(strings = {"test1,test2,test3"})
    void 자동차이름_콤마로구분해서_입력(String input) {
        String[] names = NameUtil.split(input);
        Cars cars = new Cars(names, new RandomMoveStrategy());

        assertThat(cars.getCars()).hasSize(names.length);
    }

    @DisplayName("자동차이름 길이 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"invalid"})
    void 자동차이름_5자초과(String input) {
        assertThatIllegalStateException()
                .isThrownBy(() -> NameUtil.checkNameValidation(input))
                .withMessageMatching("차 이름은 5글자를 초과할 수 없습니다. 다시 입력하세요.");
    }

    @DisplayName("자동차이름 공백 테스트")
    @ParameterizedTest
    @NullAndEmptySource
    void 자동차이름_공백_확인(String input) {
        assertThatIllegalStateException()
                .isThrownBy(() -> NameUtil.checkNameValidation(input))
                .withMessageMatching("차 이름은 공백일 수 없습니다.");
    }

    @DisplayName("우승자는 한명 이상일 수 있다.")
    @Test
    void 우승자_한명이상() {

        Car car1 = new Car("car1", 10);
        Car car2 = new Car("car2", 10);

        Cars cars = new Cars();
        cars.getCars().add(car1);
        cars.getCars().add(car2);

        List<Car> winners = cars.findWinners();

        assertThat(winners.size()).isEqualTo(2);

    }
}
