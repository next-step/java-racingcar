package racing_winner;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.RandomFactory;
import racing_winner.domain.CarRacing;
import racing_winner.view.CarRacingPrinter;

import java.util.List;

import static org.mockito.Mockito.*;

public class CarRacingTest {


    @Test
    @DisplayName("game이 정상적으로 동작을한다.")
    void gameSuccess(){
        List<String> carNames = List.of("Car1","Car2");
        int racingCount = 3;
        RandomFactory randomFactory = mock(RandomFactory.class);
        CarRacingPrinter carRacingPrinter = mock(CarRacingPrinter.class);
        CarRacing carRacing = new CarRacing(carNames, racingCount, randomFactory, carRacingPrinter);
        when(randomFactory.getNextInt()).thenReturn(4);

        carRacing.game();

        verify(carRacingPrinter).printWinners(anyList());
    }

}
