package racingcar.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.repository.CarRepository;
import racingcar.service.CarService;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RacingGameControllerTest {

    @ParameterizedTest(name = "입력한 대수가 {0}일 경우")
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    @DisplayName("입력받은 대수만큼 자동차 생성하는 테스트")
    public void createCars(int numberOfCars) throws Exception {
        //given
        CarRepository carRepository = new CarRepository();
        CarService carService = new CarService(carRepository);
        RacingGameController racingGameController = new RacingGameController(carService);

        //when
        racingGameController.createCars(numberOfCars);
        int sizeOfCars = carRepository.findAll().size();

        //then
        assertEquals(numberOfCars, sizeOfCars, "입력한 대수와 생성된 자동차의 수는 같아야한다.");
    }

    @Test
    @DisplayName("입력받은 시도 회수를 저장하는 테스트")
    public void createGameRound() throws Exception {
        //given
        CarRepository carRepository = new CarRepository();
        CarService carService = new CarService(carRepository);
        RacingGameController racingGameController = new RacingGameController(carService);

        //when

        //then
        assertThatIllegalArgumentException().isThrownBy(() -> racingGameController.createGameRound(-1)).withMessageContaining("0이하의 값인지 확인");
    }
}