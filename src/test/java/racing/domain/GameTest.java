package racing.domain;

import org.junit.Test;
import racing.view.CommonView;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    @Test
    public void 정규식() {
        boolean result = CommonView.checkPattern("abc,asdf,erwe");
        assertThat(result).isTrue();
        result = CommonView.checkPattern("a,b,c,d,e");
        assertThat(result).isTrue();
        result = CommonView.checkPattern("a,b");
        assertThat(result).isTrue();
        result = CommonView.checkPattern(" a,b");
        assertThat(result).isTrue();
        result = CommonView.checkPattern(" a,b ");
        assertThat(result).isTrue();
        result = CommonView.checkPattern("  a,b  ");
        assertThat(result).isTrue();
    }

    @Test(expected = RuntimeException.class)
    public void 정규식에러() {
        boolean result;
        result = CommonView.checkPattern(",bb,cc");
        assertThat(result).isFalse();
        result = CommonView.checkPattern("aaa,bbb,");
        assertThat(result).isFalse();
    }

    @Test
    public void 자동차생성() {
        RacingCarGame racingCarGame = new RacingCarGame();

        String[] names = CommonView.parseCarNames("aaa,bbb,ccc");
        List<Car> cars = racingCarGame.createCars(names);
        assertThat(cars.size()).isEqualTo(3);
        assertThat(cars.get(0).getName()).isEqualTo("aaa");

        names = CommonView.parseCarNames("aaa,bbb");
        cars = racingCarGame.createCars(names);
        assertThat(cars.size()).isEqualTo(2);
        assertThat(cars.get(0).getName()).isEqualTo("aaa");
    }

    @Test(expected = RuntimeException.class)
    public void 자동차생성에러() {
        RacingCarGame racingCarGame = new RacingCarGame();

        String[] names = CommonView.parseCarNames("aaa,bbb,");
        List<Car> cars = racingCarGame.createCars(names);
        assertThat(cars.size()).isEqualTo(0);

        names = CommonView.parseCarNames("aaa,bbb,");
        cars = racingCarGame.createCars(names);
        assertThat(cars.size()).isEqualTo(0);
    }
}