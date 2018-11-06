package racing;

import org.junit.Test;
import racing.rule.Forward;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
public class RacingTest {

    private static final Random random = new Random();

    @Test
    public void 자동차_숫자_만큼_자동차_목록이_생성되는지_검사() {

        final String carRacerName = "Ryan";
        final int tryCount = random.nextInt(20);

        final Game racing = new Racing(Collections.singletonList(new Car(new CarRacer(carRacerName), new Forward())), tryCount);
        assertThat(racing.getList().size()).isEqualTo(1);
    }

    @Test
    public void 게임이_끝나면_종료되는지_검사() {

        final String carRacerName = "Ryan";
        final int tryCount = random.nextInt(20);

        final Game racing = new Racing(Collections.singletonList(new Car(new CarRacer(carRacerName), new Forward())), tryCount);
        while (racing.hasTryCount()) {
            racing.start();
        }

        assertThat(racing.hasTryCount()).isEqualTo(false);
    }

    @Test
    public void 라이언과_테스터가_달리는데_라이언만_달릴수_있도록_했을때_라이언이_우승하는지() {

        final Car ryan = new Car(new CarRacer("라이언"), () -> true);
        final Car tester = new Car(new CarRacer("테스터"), () -> false);

        final Game racing = new Racing(Arrays.asList(ryan, tester), 10);
        while (racing.hasTryCount()) {
            racing.start();
        }

        final String winnerName = ryan.getPosition() > tester.getPosition() ? ryan.getCarRacer().getName() : tester.getCarRacer().getName();

        assertThat(winnerName).isEqualTo("라이언");
    }

}