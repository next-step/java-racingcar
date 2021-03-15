package step3.racingCar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import step3.racingCar.domain.Cars;
import step3.racingCar.ui.InputView;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

class GameTest {
    private Game game;
    private static final int TRY_NUM = 3;
    private static final int CAR_NUM = 4;
    private List<Object> inputs;
    MockedStatic<InputView> inputView;

    @BeforeEach
    void setUp() {
        inputs = new ArrayList<>();
        inputs.add(CAR_NUM);
        inputs.add(TRY_NUM);

        inputView = mockStatic(InputView.class);
        when(InputView.input(new String[]{Game.HOW_MANY_CARS, Game.HOW_MANY_TRYS}))
                .thenReturn(inputs);
        game = new Game();
        inputView.close();
    }

    @Test
    void createGame() {
        assertThat(game).extracting("tryNum")
                .containsOnly(TRY_NUM);

        assertThat(game).extracting("racingCars")
                .hasOnlyElementsOfType(Cars.class);
    }

    @Test
    void playGame() {

        game.play();
    }

}
