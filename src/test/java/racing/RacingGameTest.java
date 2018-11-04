package racing;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Random;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
public class RacingGameTest {
    Random random = new Random();
    RacingGame racingGame;
    @Before
    public void setUp()  {
        String str = "pobi,crong,honux";
        int count = 5;
        racingGame = new RacingGame(str,count);
    }

    @Test
    public void 랜덤학습테스트() {

        int result = 0;
        for(int i = 0; i < 100; i++){
            result = random.nextInt(10);
            assertThat(result).isGreaterThanOrEqualTo(0);
            assertThat(result).isLessThan(10);
        }
    }
    @Test
    public void 준비_및_초기화확인() {
        assertThat(racingGame.getName(0)).isEqualTo("pobi");
        assertThat(racingGame.getName(1)).isEqualTo("crong");
        assertThat(racingGame.getName(2)).isEqualTo("honux");

    }
    @Test
    public void 이동_및_이동거리확인() {
        List<Car> result = null;
        for(int i =0; i < racingGame.getTime(); i++){
            result = racingGame.move();
        }

        for(int i =0; i < result.size(); i++){
            assertThat(result.get(i).getPosition()).isGreaterThanOrEqualTo(0);
            assertThat(result.get(i).getPosition()).isLessThanOrEqualTo(5);
        }
    }



    @Test
    public void 플레이어초기화() {
        assertThat(racingGame.getCarCount()).isEqualTo(3);
        assertThat(racingGame.getName(0)).isEqualTo("pobi");
        ResultView.watchRace(racingGame);

        System.out.println("최종우승했습니다.");
    }


    @Test
    public void 끝이콤마로끝나면() {
        String str = "pobi,crong,honux,";
        int count = 5;
        racingGame = new RacingGame(str,count);
        assertThat(racingGame.getCarCount()).isEqualTo(3);
        assertThat(racingGame.getName(0)).isEqualTo("pobi");
        ResultView.watchRace(racingGame);
    }

    @Test(expected = NullPointerException.class)
    public void null값테스트() {
        String str = null;
        int count = 5;
        racingGame = new RacingGame(str,count);
        assertThat(racingGame.getCarCount()).isEqualTo(3);
        assertThat(racingGame.getName(0)).isEqualTo("pobi");
        ResultView.watchRace(racingGame);

        System.out.println("최종우승했습니다.");
    }
}