package step3_racingCar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

class GameTest {
    private Game game;
    private static final int TRYNUM = 3;
    private static final int CARNUM = 4;
    private ArrayList<Integer> inputs;
    MockedStatic<InputView> inputView;

    @BeforeEach
    void setUp(){
        inputs = new ArrayList<>();
        inputs.add(CARNUM);
        inputs.add(TRYNUM);

        inputView = mockStatic(InputView.class);
        when(InputView.input(Game.strs))
                .thenReturn(inputs);
        game = new Game();
        inputView.close();
    }

    @Test
    void createGame(){
        assertThat(game).extracting("tryNum")
                .containsOnly(TRYNUM);

        assertThat(game).extracting("racingCars")
                .hasOnlyElementsOfType(Cars.class);
    }

}
