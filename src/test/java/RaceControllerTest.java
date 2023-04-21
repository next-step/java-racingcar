import controller.RaceController;
import model.AlwaysMoveStrategy;
import model.Race;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import view.RaceView;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class RaceControllerTest {
    @Test
    public void numberOfCarsQueriedAndCreated() {
        var numberOfCars = 3;
        var strategy = new AlwaysMoveStrategy();

        var raceViewMock = Mockito.mock(RaceView.class);
        when(raceViewMock.queryAndGetNumberOfCars()).thenReturn(numberOfCars);

        var race = new Race();
        var raceController = new RaceController(race, raceViewMock);
        raceController.startRace(strategy);

        assertThat(race.getCarPositions()).hasSize(numberOfCars);
    }

    @Test
    public void carsMoved() {
        var numberOfCars = 3;
        var steps = 5;
        var strategy = new AlwaysMoveStrategy();

        var raceViewMock = Mockito.mock(RaceView.class);
        when(raceViewMock.queryAndGetNumberOfCars()).thenReturn(numberOfCars);
        when(raceViewMock.queryAndGetSteps()).thenReturn(steps);

        var race = new Race();
        var raceController = new RaceController(race, raceViewMock);
        raceController.startRace(strategy);


        for (var carPosition : race.getCarPositions()) {
            assertThat(carPosition).isEqualTo(steps);
        }
    }

    @Test
    public void raceResultTitlePrinted() {
        var numberOfCars = 3;
        var steps = 5;
        var strategy = new AlwaysMoveStrategy();

        var raceViewMock = Mockito.mock(RaceView.class);
        when(raceViewMock.queryAndGetNumberOfCars()).thenReturn(numberOfCars);
        when(raceViewMock.queryAndGetSteps()).thenReturn(steps);

        var race = new Race();
        var raceController = new RaceController(race, raceViewMock);
        raceController.startRace(strategy);

        verify(raceViewMock).printResultTitle();
    }

    @Test
    public void raceResultsPrinted() {
        var numberOfCars = 3;
        var steps = 5;
        var strategy = new AlwaysMoveStrategy();

        var raceViewMock = Mockito.mock(RaceView.class);
        when(raceViewMock.queryAndGetNumberOfCars()).thenReturn(numberOfCars);
        when(raceViewMock.queryAndGetSteps()).thenReturn(steps);

        var race = new Race();
        var raceController = new RaceController(race, raceViewMock);
        raceController.startRace(strategy);

        verify(raceViewMock, times(steps)).printCurrentRaceStatus(anyList());
    }
}
