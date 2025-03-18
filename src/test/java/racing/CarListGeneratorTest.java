package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.entity.Car;
import racing.generator.CarListGenerator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarListGeneratorTest {

    @Test
    @DisplayName("전달받은 자동차 이름 리스트 기반으로 Car 객체 리스트 생성한다.")
    public void generate_carInstanceList_from_nameList() {
        // given
        List<String> userInput = List.of("ford", "kia", "tesla");

        // when
        List<Car> actual = CarListGenerator.generateCarList(userInput);

        // then
        List<Car> expected = List.of(new Car("ford"), new Car("kia"), new Car("tesla"));
        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
    }

}