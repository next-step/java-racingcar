package car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
public class carTest {
    private List<Car> cars;
    private final int condVal = 10;

    @BeforeEach
    void setUp() {
        cars = new ArrayList<>();
        cars.add(new Car( "그랜저", 3));
        cars.add(new Car( "제네시스", 1));
        cars.add(new Car( "레이",0));
        System.out.println(cars.get(0).getName());
    }
    @ParameterizedTest
    @ValueSource(strings = {"pobi,woni,jun"})
    void 자동차_이름은_쉼표구분자로_구분한다(String carName) {
        //when
        String[] carNames = carName.split(",");

        //then
        assertThat(carNames).containsExactly("pobi", "woni", "jun");
        for (int i = 0; i < carNames.length; i++) {
            System.out.println(carNames[i]);
        }

    }

    @ParameterizedTest
    @CsvSource(value = {"pobi,woni,jun:5"}, delimiter = ':')
    void 자동차_이름과_이동횟수를_입력한다(String carName, int moveCount) {
        String[] carNames = carName.split(",");
        assertThat(carNames).containsExactly("pobi", "woni", "jun");
        assertThat(moveCount).isEqualTo(5);
        for (int i = 0; i < carNames.length; i++) {
            System.out.println(carNames[i]);
        }
    }

    @Test
    void 레이싱테스트() {
        cars.forEach(car -> {
            int randomValue = Car.generateRandomValueBy(10);
            car.move(randomValue);
        });
    }


}