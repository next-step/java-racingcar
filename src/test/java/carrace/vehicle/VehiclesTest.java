package carrace.vehicle;

import carrace.movement.car.CarMovement;
import carrace.vehicle.car.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class VehiclesTest {

    @DisplayName("자동차 대수 2대 이상이 들어오면 정상적으로 만들어집니다.")
    @Test
    public void VehiclesTest_ValidInputVehicles() {

        Vehicles vehicles =
                new Vehicles(
                        new Vehicle[] {
                            new Car("car1", new CarMovement()), new Car("car2", new CarMovement())
                        });

        // nothing happen
    }

    @DisplayName("자동차 대수 2대 미만이 들어오면 예외가 발생합니다.")
    @Test
    public void VehiclesTest_InvalidInputVehicles() {

        assertThatThrownBy(
                        () ->
                                new Vehicles(
                                        new Vehicle[] {
                                            new Car("car1", new CarMovement()),
                                        }))
                .isInstanceOf(RuntimeException.class);
    }
}
