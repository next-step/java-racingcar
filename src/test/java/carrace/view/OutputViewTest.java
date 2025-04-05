package carrace.view;

import carrace.vehicle.Vehicle;
import carrace.vehicle.Vehicles;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class OutputViewTest {

    @DisplayName("자동차 상태 출력시, 탈것의 개수가 2개 이상이어야합니다.")
    @Test
    public void printCurrentStateTest_NoVehicles() {
        OutputView outputView = new OutputView();
        Vehicle[] inputVehicle = new Vehicle[0];
        Vehicles inputVehicles = new Vehicles(inputVehicle);

        assertThatThrownBy(() -> outputView.printCurrentState(inputVehicles))
                .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("우승자 문자열이 빈 문자열이여서는 안됩니다.")
    @Test
    public void printWinner_NoWinner() {
        OutputView outputView = new OutputView();
        String inputWinner = "";

        assertThatThrownBy(() -> outputView.printWinner(inputWinner))
                .isInstanceOf(RuntimeException.class);
    }
}
