package step5.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step5.domain.Car;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RacingCarControllerTest {

    RacingCarController racingCarController;

    @BeforeEach
    void setUp() {
        racingCarController = new RacingCarController();
    }

    @Test
    @DisplayName("입력한 자동차 갯수 일치 확인")
    public void 입력한_자동차_갯수_일치_확인() {
        String[] carNames = "zu,cu,du".split(",");
        List<Car> cars = racingCarController.start(carNames);
        assertEquals(carNames.length, cars.size());
    }

    @Test
    @DisplayName("입력한 자동차 값이 정상 등록되는지")
    public void 등록_자동차_확인() {
        String[] carNames = "zu,cu,du".split(",");
        List<Car> cars = racingCarController.start(carNames);
        assertEquals(cars.get(0).getCarName(), "zu");
        assertEquals(cars.get(1).getCarName(), "cu");
        assertEquals(cars.get(2).getCarName(), "du");
    }
}
