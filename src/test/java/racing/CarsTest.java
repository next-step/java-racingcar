package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {
    Cars cars;

    @BeforeEach
    void setUp() {
        cars = new Cars();
    }

    @Test
    @DisplayName("아무 이름 입력하지 않으면 빈 Cars 생성")
    void no_names_then_empty_cars() {
        String testNames = "";
        assertThatThrownBy(()-> {cars.generateCarsWithName(testNames);})
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름을 입력 하세요");
    }

    @ParameterizedTest
    @ValueSource(strings = {"소나", "탐켄치"})
    @DisplayName("입력한 이름을 가진 Cars 생성")
    void generate_cars_with_name(String name) {
        String testNames = "소나,탐켄치";
        Cars generateCars = cars.generateCarsWithName(testNames);
        List<String> carNames = generateCars.getCars().stream().map(Car::getName).collect(Collectors.toList());
        assertThat(carNames.contains(name)).isTrue();
    }

    @Test
    @DisplayName("다섯자를 초과하는 이름을 입력한 경우 익셉션")
    void exceeding_5_characters_then_exception() {
        String testNames = "럭스,하이머딩거다";
        assertThatThrownBy(()-> {cars.generateCarsWithName(testNames);})
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름 다섯자 초과");
    }
}