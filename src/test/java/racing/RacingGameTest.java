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
        List<Car> result = racingGame.getCars();
        for(int i =0; i < racingGame.getTime(); i++){
            result = racingGame.move();
        }

        for(int i =0; i < result.size(); i++){
            assertThat(result.get(i).getPosition()).isLessThanOrEqualTo(6);
        }
    }



    @Test
    public void 플레이어초기화() {
        assertThat(racingGame.getCarCount()).isEqualTo(3);
        assertThat(racingGame.getName(0)).isEqualTo("pobi");


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

    }

    @Test
    public void test(){
        ResultView.watchRace(racingGame);
    }

    @Test
    public void 최종결과테스트() {
        int maxNum = 0;
        String result = "";
        List<Car> cars  = racingGame.move();
        for(Car car : cars){
            maxNum = car.getMaxPosition(maxNum);
        }
        assertThat(maxNum).isLessThanOrEqualTo(1);
        for(Car car : cars){
            result += car.getWinner(maxNum);
        }

        result = result.substring(0, result.length() -1 );
        assertThat("pobi,crong,honux").contains(result);
        result += "가 최종 우승했습니다.";
        System.out.println(result);
    }
}