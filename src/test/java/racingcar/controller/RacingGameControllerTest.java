package racingcar.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.repository.CarRepository;
import racingcar.repository.GameRoundRepository;
import racingcar.service.CarService;
import racingcar.service.GameRoundService;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RacingGameControllerTest {

    private CarRepository carRepository;
    private CarService carService;
    private GameRoundRepository gameRoundRepository;
    private GameRoundService gameRoundService;
    private RacingGameController racingGameController;

    @BeforeEach
    public void setUp() {
        this.carRepository = new CarRepository();
        this.carService = new CarService(this.carRepository);
        this.gameRoundRepository = new GameRoundRepository();
        this.gameRoundService = new GameRoundService(this.gameRoundRepository);
        this.racingGameController = new RacingGameController(this.carService, this.gameRoundService);
    }

    @Test
    @DisplayName("자동차 생성하는 테스트")
    public void createCars() throws Exception {
        //when
        String[] names = {"one", "two", "three"};
        racingGameController.createCars(names);
        int sizeOfCars = carRepository.findAll().size();

        //then
        assertEquals(names.length, sizeOfCars, "입력한 대수와 생성된 자동차의 수는 같아야한다.");
    }

    @Test
    @DisplayName("입력받은 시도 회수가 정수가 아닐 경우 에러")
    public void createGameRound() throws Exception {
        assertThatIllegalArgumentException().isThrownBy(() -> racingGameController.createGameRound(-1)).withMessageContaining("0이하의 값인지 확인");
    }
}