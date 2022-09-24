package step3.racinggame.core;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.racinggame.exception.EmptyTankException;
import step3.racinggame.exception.InvalidFuelException;

class FuelTankTest {

    @Test
    @DisplayName("연료가 있는 연료탱크에서 연료 꺼내기 테스트")
    void get_fuel() {
        FuelTank fuelTank = new FuelTank();
        fuelTank.addFuel(4);

        assertThat(fuelTank.takeFuel()).isEqualTo(4);
    }

    @Test
    @DisplayName("연료가 없는 연료탱크에서 연료 꺼낼 시 예외 발생 테스트")
    void fail_to_get_fuel_in_empty_tank() {
        FuelTank fuelTank = new FuelTank();

        assertThatThrownBy(
                fuelTank::takeFuel)
                .isInstanceOf(EmptyTankException.class);
    }

    @Test
    @DisplayName("허용되는 범위값의 연료 추가 테스트")
    void add_fuel() {
        FuelTank fuelTank = new FuelTank();
        int validFuel = 4;
        fuelTank.addFuel(validFuel);

        assertThat(fuelTank.takeFuel()).isEqualTo(4);
    }

    @Test
    @DisplayName("허용되지 않는 범위값의 연료 추가 시 예외 발생 테스트")
    void fail_to_add_fuel_about_invalid_fuel() {
        FuelTank fuelTank = new FuelTank();
        int invalidFuel = -1;

        assertThatThrownBy(() -> fuelTank.addFuel(invalidFuel))
                .isInstanceOf(InvalidFuelException.class);
    }

}