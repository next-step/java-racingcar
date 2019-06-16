package step2.racing.ui;

import org.junit.jupiter.api.*;
import step2.racing.dto.CarPosition;
import step2.racing.dto.RacingResult;
import step2.racing.model.Car;

import java.io.*;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

class ResultViewTest {

    private ResultView resultView;

    private OutputStream byteArrayOutputStream = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {

        resultView = new ResultView(new PrintStream(byteArrayOutputStream));
    }

    @Test
    @DisplayName("차량 위치 출력 검증")
    void printEntireCarsPosition() {

        Map<Integer, Integer> carNumberPositionMap = new HashMap<>();
        carNumberPositionMap.put(1, 7);
        carNumberPositionMap.put(2, 2);
        carNumberPositionMap.put(3, 4);
        CarPosition carPosition = new CarPosition(carNumberPositionMap);
        RacingResult racingResult = new RacingResult();
        racingResult.add(carPosition);

        resultView.printTotalRaces(racingResult);

        assertThat(byteArrayOutputStream.toString())
                .isEqualTo("\n"
                                   + "-------\n"
                                   + "--\n"
                                   + "----\n"
                                   + "\n");
    }
}