package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingCarTest {

//    @Test
//    void 뷰_실행() {
//        ResultView resultView = new ResultView();
//        resultView.startRacing();
//    }

    @Test
    void 랜덤값_0_9() {
        int randomNumber = RacingCarUtil.getRandomNumberZeroToNine();
        System.out.println(randomNumber);
    }

    @Test
    void 전진_4이상() {
        RacingCar racingCar = new RacingCar();

        // TODO:: 랜덤 값인데 어떻게 테스트 해야...? 통과 될 때의 조건...
        racingCar.moveForward(RacingCarUtil.getRandomNumberZeroToNine());

        assertThat(racingCar.position()).isEqualTo(2);
    }


}
