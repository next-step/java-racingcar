package carrace.app;

import carrace.race.Race;
import carrace.vehicle.Vehicle;
import carrace.vehicle.Vehicles;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RaceTest {

    private Race race;

    private static final String POBI = "pobi";
    private static final String CRONG = "crong";

    @Mock private Vehicle car1;
    @Mock private Vehicle car2;
    @Mock private Vehicles mockVehicles = new Vehicles(new Vehicle[] {car1, car2});

    @DisplayName("가장 멀리 간 자동차 한 대가 최종 우승자로 나와야 합니다.")
    @Test
    void getWinner_ShouldReturnSingleWinner() {
        when(car1.getCarName()).thenReturn(POBI);
        when(car1.getCurrentPosition()).thenReturn(5);
        //        when(car2.getCarName()).thenReturn(CRONG); 실제 호출안되는 when을 추가하니 에러 발생
        //        when(car1.getCurrentPosition()).thenReturn(3);

        Vehicle[] vehiclesArray = {car1, car2};
        when(mockVehicles.getVehicles()).thenReturn(vehiclesArray);

        race = new Race(mockVehicles);

        List<String> winners = race.getWinner();

        assertThat(winners).isEqualTo(List.of(POBI));
    }

    @DisplayName("가장 멀리 간 자동차가 여러 대일 경우 모두 최종 우승자로 나와야 합니다.")
    @Test
    void getWinner_ShouldReturnMultipleWinners() {
        when(car1.getCarName()).thenReturn(POBI);
        when(car1.getCurrentPosition()).thenReturn(5);
        when(car2.getCarName()).thenReturn(CRONG);
        when(car2.getCurrentPosition()).thenReturn(5);

        Vehicle[] vehiclesArray = {car1, car2};
        when(mockVehicles.getVehicles()).thenReturn(vehiclesArray);

        race = new Race(mockVehicles);
        List<String> winners = race.getWinner();

        assertThat(winners).containsExactlyInAnyOrder(POBI, CRONG);
    }
}
