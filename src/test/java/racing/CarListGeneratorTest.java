package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.Car;
import racing.generator.CarListGenerator;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class CarListGeneratorTest {

    @Test
    @DisplayName("전달받은 자동차 이름 리스트 기반으로 Car 객체 리스트 생성한다.")
    public void generate_carInstanceList_from_nameList() {
        // given
        List<String> userInput = List.of("ford", "kia", "tesla");

        // when
        List<Car> carList = CarListGenerator.generateCarList(userInput);
        List<String> actual = carList.stream().map(Car::getCarName).collect(Collectors.toList());

        // then
        List<String> expected = List.of("ford", "kia", "tesla");
        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
    }

}