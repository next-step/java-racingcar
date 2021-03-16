package racingcar.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;
import racingcar.repository.CarRepository;
import racingcar.repository.GameRoundRepository;
import racingcar.service.CarService;
import racingcar.service.GameRoundService;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RacingGameControllerTest {

    private List<Car> cars;
    private CarRepository carRepository;
    private CarService carService;
    private GameRoundRepository gameRoundRepository;
    private GameRoundService gameRoundService;
    private RacingGameController racingGameController;

    @BeforeEach
    public void setUp() {
        this.cars = new ArrayList<>();
        this.carRepository = new CarRepository(cars);
        this.carService = new CarService(this.carRepository);
        this.gameRoundRepository = new GameRoundRepository();
        this.gameRoundService = new GameRoundService(this.gameRoundRepository);
        this.racingGameController = new RacingGameController(this.carService, this.gameRoundService);
    }

    @Test
    @DisplayName("자동차 생성하는 테스트")
    public void createCars() throws Exception {
        //when
        String[] names = {"sean", "pobi", "bibi"};
        racingGameController.createCars(names);
        List<Car> cars = carRepository.findAll();

        //then
        assertThat(cars).hasSize(3);
    }

    @Test
    @DisplayName("입력받은 시도 회수가 정수가 아닐 경우 에러")
    public void createGameRound() throws Exception {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> racingGameController.createGameRound(-1)).withMessageContaining("0이하의 값인지 확인");
    }
}