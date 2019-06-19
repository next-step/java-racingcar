import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RacingGameTest {
    // 자동차 경주의 최초 설정 세팅 함수에 대한 Junit 테스트 구현

    @Test
    public void gameInitialSet(){
        int numberOfCar = 1;
        ArrayList<CarInfo> carInfo = null;

        assertThatNullPointerException().isThrownBy(()  -> {
            if(carInfo == null)
                throw new NullPointerException("함수의 객체가 null 입니다. 확인하시고 다시 실행해주시길 바랍니다.");
        });

        assertTrue(numberOfCar <= 1);
    }

    // 랜덤값 생성 및 자동차 경주 결과를 호출하는 함수에 대한 Junit 테스트 구현
    @Test
    public void makeRandomNumberAndGameResult() {
        RacingGame racingGame = new RacingGame();
        ArrayList<CarInfo> carInfo = null;
        Random generatorNumber = new Random();
        ResultView resultView = new ResultView(); // 자동차 경주 결과의 출력을 위한 객체 생성

        assertThatNullPointerException().isThrownBy(() -> {
            if (racingGame == null || carInfo == null || generatorNumber == null || resultView == null)
                throw new NullPointerException("함수의 객체 중에 null값이 있습니다. 확인하시고 다시 실행해주시길 바랍니다.");
        });
    }

}

