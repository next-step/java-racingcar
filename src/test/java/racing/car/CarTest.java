package racing.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @CsvSource({
            "FULL,true",
            "EMPTY,false"
    })
    @DisplayName("Move 테스트")
    @ParameterizedTest
    public void moveTest(String fuelName, boolean movement) {
        Fuel fuel = Fuel.valueOf(fuelName);

        Car car = new Car();
        car.move(fuel);

        assertThat(
                car.getLocation().hasValue()
        ).withFailMessage("지정한 횟수만큼 이동하지 않았습니다.")
                .isEqualTo(movement);
    }
}