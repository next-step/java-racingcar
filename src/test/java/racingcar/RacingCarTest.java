package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.OperatorManager;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {
    RacingDTO racingDTO;
    // @Test 메소드 실행되기전 수행
    @BeforeEach
    void setUp(){
        racingDTO = new RacingDTO(3,5);
    }

    @Test
    @DisplayName("자동차 주행 테스트")
    public void carTest(){
        Car car = new Car();
        MoveCheckor moveCheckor = new MoveCheckor();
        moveCheckor.moveAndStop(car,4);
    }

    @Test
    @DisplayName("생성된 자동차 객체수 확인 테스트")
    public void numberOfCarTest(){
        RacingCar racingCar = new RacingCar(racingDTO);
        racingCar.readToCar(3);
        assertThat(racingCar.getCars()).isEqualTo(3);
    }

    @Test
    @DisplayName("경기 테스트")
    public void racingTest(){
        RacingCar racingCar = new RacingCar(racingDTO);
        racingCar.start();
    }

    @Test
    @DisplayName("경기 진행 및 결과 출력 테스트")
    public void resultTest(){
        RacingCar racingCar = new RacingCar(racingDTO);
        racingCar.start();

        int counts = racingDTO.getCounts();
        int attempts = racingDTO.getAttempts();

        ResultView resultView = new ResultView(counts, attempts);
        resultView.showResult(racingCar.getCars());
    }


}
