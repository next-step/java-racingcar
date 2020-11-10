package racingcar.application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarsGeneratorTest {

    private CarsGenerator carsGenerator;

    @BeforeEach
    public void setUp() {
        carsGenerator = new CarsGenerator();
    }

    @Test
    @DisplayName("입력된 이름의 수 만큼 자동차들을 생성한다.")
    public void should_create_cars() {
        String nameOfCars = "git,pron,abc";
        List<Car> cars = carsGenerator.generateCars(nameOfCars);
        assertThat(cars.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    @DisplayName("입력된 이름이 빈 공백이면 IllegalArgumentException 던진다.")
    public void should_throw_IllegalArgumentException_when_name_is_less_than_5_characters(String name) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> carsGenerator.generateCars(name))
                .withMessage("the name must not blank.");
    }

    @Test
    @DisplayName("입력된 이름이 5글자 이상이면 IllegalArgumentException 던진다.")
    public void should_throw_IllegalArgumentException_when_name_is_more_than_5_characters() {
        String nameOfCars = "hoonick,pron,abc";

        assertThatIllegalArgumentException()
                .isThrownBy(() -> carsGenerator.generateCars(nameOfCars))
                .withMessage("the name must be less than five characters.");
    }

}