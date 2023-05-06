package racinggame;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racinggame.common.constants.RexFormatConstants;
import racinggame.domain.Car;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RacingCarGameTest {

    private RacingCarGame racingCarGame;

    @BeforeAll
    void setUp() {
        this.racingCarGame = new RacingCarGame();
    }

    @DisplayName("자동차 대수 만큼 생성 생성")
    @ParameterizedTest
    @ValueSource(strings = {"pobi,crong,honux"})
    void createCars(String carsName) {
        Map<Integer, Car> carMap;
        carMap = racingCarGame.createCars(carsName.split(RexFormatConstants.CARS_NAME_REX_FORMAT_TEXT.getFormat()));
        assertThat(carMap).hasSize(3);
    }

}
