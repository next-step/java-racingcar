import domain.*;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class RacingGameTest extends RacingGame{
    public RacingGameTest(){
        super(mock(Input.class), mock(Output.class), mock(Condition.class));
        when(input.nextInt()).thenReturn(3);
    }

    @Test
    public void init_game() {
        init();
        assertThat(gameCount).isGreaterThan(0);
        assertThat(cars.size()).isGreaterThan(0);
    }

    @Test
    public void start() {
        init();
        play();
        verify(output, times(gameCount)).carMileage(cars);
        verify(condition, times(gameCount * cars.size())).canPass();
    }
}
