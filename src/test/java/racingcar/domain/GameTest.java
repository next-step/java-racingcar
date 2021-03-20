package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import racingcar.ui.InputView;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;
import static racingcar.GameFactory.STEP3_STR;
import static racingcar.GameFactory.STEP4_STR;

class GameTest {
    private Game step3Game;
    private Game step4Game;
    private static final int TRY_NUM = 3;
    private static final int CAR_NUM = 4;
    private static final String NAME1 = "name1";
    private static final String NAME2 = "name2";
    private static final String NAME3 = "name3";
    private static final String NAMES = NAME1 + "," + NAME2 + "," + NAME3;
    private List<Object> inputs;
    private List<Object> step4Inputs;
    MockedStatic<InputView> inputView;

    @BeforeEach
    void setUp() {
        inputView = mockStatic(InputView.class);
        createStep3Input();
        createStep4Input();
        inputView.close();
    }

    void createStep3Input() {
        inputs = new ArrayList<>();
        inputs.add(CAR_NUM);
        inputs.add(TRY_NUM);
        when(InputView.input(STEP3_STR))
                .thenReturn(inputs);
        step3Game = new Game(STEP3_STR, inputs);

    }

    void createStep4Input() {
        step4Inputs = new ArrayList<>();
        step4Inputs.add(NAMES);
        step4Inputs.add(TRY_NUM);
        when(InputView.input(STEP4_STR))
                .thenReturn(step4Inputs);
        step4Game = new Game(STEP4_STR, step4Inputs);
    }

    @Test
    void createGame() {
        assertThat(step3Game).extracting("tryNum")
                .containsOnly(TRY_NUM);
        assertThat(step3Game).extracting("racingCars")
                .hasOnlyElementsOfType(Cars.class);

        assertThat(step4Game).extracting("tryNum")
                .containsOnly(TRY_NUM);
        assertThat(step4Game).extracting("racingCars")
                .hasOnlyElementsOfType(Cars.class);
    }

    @Test
    void playGame() {
        step4Game.play();
    }

}
