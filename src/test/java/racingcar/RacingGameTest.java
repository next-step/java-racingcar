package racingcar;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    RacingGame racingGame;

    //TODO: 궁금한점이 있습니다
    //1. Test를 위해 RacingGame 클래스에 getter를 만들었는데, 이렇게 해도 되는건가요?
    //2. return type이 void인 method에 대해서는 Test를 어떻게 만들어야하는지 잘 모르겠습니다.

    @Test
    public void 한대_전진_정지_확인() {

        this.racingGame = new RacingGame(1, 3);

        int[] carPosition = racingGame.getCarPosition();
        assertThat(carPosition[0]).isEqualTo(0);

        racingGame.determineMoveOrNot(0);

        System.out.println(carPosition[0]);
        assertThat(carPosition[0]).isBetween(0,1);
    }

    @Test
    public void 한번_모든차량_전진_정지_확인() {
        this.racingGame = new RacingGame(1, 3);

        assertThat(racingGame.getCarPosition()[0]).isEqualTo(0);
        assertThat(racingGame.getCarPosition()[1]).isEqualTo(0);
        assertThat(racingGame.getCarPosition()[2]).isEqualTo(0);

        racingGame.getMovePower();

        assertThat(racingGame.getCarPosition()[0]).isBetween(0,1);
        assertThat(racingGame.getCarPosition()[1]).isBetween(0,1);
        assertThat(racingGame.getCarPosition()[2]).isBetween(0,1);

        System.out.println(racingGame.getCarPosition()[0]);
        System.out.println(racingGame.getCarPosition()[1]);
        System.out.println(racingGame.getCarPosition()[2]);

    }

    @Test
    public void 레이싱_게임_3대_5회() {
        this.racingGame = new RacingGame(5, 3);
        racingGame.move();

        assertThat(racingGame.getCarPosition()[0]).isBetween(0,4);
        assertThat(racingGame.getCarPosition()[1]).isBetween(0,4);
        assertThat(racingGame.getCarPosition()[2]).isBetween(0,4);
    }
}