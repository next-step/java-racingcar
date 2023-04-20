import controller.RaceController;
import model.AlwaysMoveStrategy;
import model.Race;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import view.RaceView;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyMap;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class RaceControllerTest {
    @Test
    public void namesOfCarsQueriedAndCreated() {
        var namesOfCars = List.of("car1", "car2", "car3");
        var strategy = new AlwaysMoveStrategy();

        var raceViewMock = Mockito.mock(RaceView.class);
        when(raceViewMock.queryAndGetNamesOfCars()).thenReturn(namesOfCars);

        var race = new Race();
        var raceController = new RaceController(race, raceViewMock);
        raceController.startRace(strategy);

        assertThat(race.getCarPositions()).hasSize(namesOfCars.size());
    }

    @Test
    public void carsMoved() {
        var namesOfCars = List.of("car1", "car2", "car3");
        var steps = 5;
        var strategy = new AlwaysMoveStrategy();

        var raceViewMock = Mockito.mock(RaceView.class);
        when(raceViewMock.queryAndGetNamesOfCars()).thenReturn(namesOfCars);
        when(raceViewMock.queryAndGetSteps()).thenReturn(steps);

        var race = new Race();
        var raceController = new RaceController(race, raceViewMock);
        raceController.startRace(strategy);


        for (var carPosition : race.getCarPositions().values()) {
            assertThat(carPosition).isEqualTo(steps);
        }
    }

    @Test
    public void raceResultTitlePrinted() {
        var namesOfCars = List.of("car1", "car2", "car3");
        var steps = 5;
        var strategy = new AlwaysMoveStrategy();

        var raceViewMock = Mockito.mock(RaceView.class);
        when(raceViewMock.queryAndGetNamesOfCars()).thenReturn(namesOfCars);
        when(raceViewMock.queryAndGetSteps()).thenReturn(steps);

        var race = new Race();
        var raceController = new RaceController(race, raceViewMock);
        raceController.startRace(strategy);

        verify(raceViewMock).printResultTitle();
    }

    @Test
    public void raceResultsPrinted() {
        var namesOfCars = List.of("car1", "car2", "car3");
        var steps = 5;
        var strategy = new AlwaysMoveStrategy();

        var raceViewMock = Mockito.mock(RaceView.class);
        when(raceViewMock.queryAndGetNamesOfCars()).thenReturn(namesOfCars);
        when(raceViewMock.queryAndGetSteps()).thenReturn(steps);

        var race = new Race();
        var raceController = new RaceController(race, raceViewMock);
        raceController.startRace(strategy);

        verify(raceViewMock, times(steps)).printCurrentRaceStatus(anyMap());
    }
}
