package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.racing.RacingDTO;
import racingcar.domain.racing.RacingGame;
import racingcar.view.ResultView;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
    RacingDTO racingDTO;
    // @Test 메소드 실행되기전 수행
    @BeforeEach
    void setUp(){
        String inputName = "pobi,crong,honux";
        racingDTO = new  RacingDTO(inputName,5);
    }


    @Test
    @DisplayName("자동차 경기 진행 지시 테스트")
    public void instructionTest(){
        RacingGame racingGame = new RacingGame(racingDTO);
        Car testCar = new Car("pobi");
        racingGame.instructMove(testCar);

        assertThat(testCar.getRecord(5)).isNotNull();
    }

    @Test
    @DisplayName("경기 테스트")
    public void racingTest(){
        RacingGame racingGame = new RacingGame(racingDTO);
        racingGame.start();
    }

    @Test
    @DisplayName("경기 진행 및 결과 출력 테스트")
    public void resultTest(){
        RacingGame racingGame = new RacingGame(racingDTO);
        racingGame.start();
        Cars cars = racingGame.end();

        int counts = cars.getPlayerNumber();
        int attempts = racingDTO.getAttempts();

        ResultView resultView = new ResultView(counts, attempts);
        resultView.showResult(cars);
        resultView.announceWinner(cars.findWinner());
    }


}