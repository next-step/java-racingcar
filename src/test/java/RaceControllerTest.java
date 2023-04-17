import controller.RaceController;
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
    public void nCarsQueriedAndCreated() {
        var numberOfCars = 3;

        var raceViewMock = Mockito.mock(RaceView.class);
        when(raceViewMock.queryAndGetNumberOfCars()).thenReturn(numberOfCars);

        var race = new Race();
        var raceController = new RaceController(race, raceViewMock);
        raceController.startRace();

        assertThat(race.getCarPositions()).hasSize(numberOfCars);
    }

    @Test
    public void carsMoved() {
        var numberOfCars = 3;
        var steps = 100;
        var moveProbability = 0.6;
        var toleranceRatio = 0.2;

        var raceViewMock = Mockito.mock(RaceView.class);
        when(raceViewMock.queryAndGetNumberOfCars()).thenReturn(numberOfCars);
        when(raceViewMock.queryAndGetSteps()).thenReturn(steps);

        var race = new Race();
        var raceController = new RaceController(race, raceViewMock);
        raceController.startRace();

        var minimumExpectedPosition = (int) ((steps * moveProbability) - (steps * toleranceRatio));
        var maximumExpectedPosition = (int) ((steps * moveProbability) + (steps * toleranceRatio));

        for (var carPosition : race.getCarPositions()) {
            assertThat(carPosition).isGreaterThan(minimumExpectedPosition).isLessThan(maximumExpectedPosition);
        }
    }

    @Test
    public void raceResultTitlePrinted() {
        var numberOfCars = 3;
        var steps = 5;

        var raceViewMock = Mockito.mock(RaceView.class);
        when(raceViewMock.queryAndGetNumberOfCars()).thenReturn(numberOfCars);
        when(raceViewMock.queryAndGetSteps()).thenReturn(steps);

        var race = new Race();
        var raceController = new RaceController(race, raceViewMock);
        raceController.startRace();

        verify(raceViewMock).printResultTitle();
    }

    @Test
    public void raceResultsArePrinted() {
        var numberOfCars = 3;
        var steps = 5;

        var raceViewMock = Mockito.mock(RaceView.class);
        when(raceViewMock.queryAndGetNumberOfCars()).thenReturn(numberOfCars);
        when(raceViewMock.queryAndGetSteps()).thenReturn(steps);

        var race = new Race();
        var raceController = new RaceController(race, raceViewMock);
        raceController.startRace();

        verify(raceViewMock, times(steps)).printCurrentRaceStatus(anyList());
    }
}
