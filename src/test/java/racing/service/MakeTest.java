package racing.service;

import org.junit.Test;
import racing.domain.Car;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MakeTest {

    @Test
    public void 정규식() {
        boolean result = RacingCarView.checkPattern("abc,asdf,erwe");
        assertThat(result).isTrue();
        result = RacingCarView.checkPattern("a,b,c,d,e");
        assertThat(result).isTrue();
        result = RacingCarView.checkPattern("a,b");
        assertThat(result).isTrue();
        result = RacingCarView.checkPattern(" a,b");
        assertThat(result).isTrue();
        result = RacingCarView.checkPattern(" a,b ");
        assertThat(result).isTrue();
        result = RacingCarView.checkPattern("  a,b  ");
        assertThat(result).isTrue();
    }

    @Test(expected = RuntimeException.class)
    public void 정규식에러() {
        boolean result;
        result = RacingCarView.checkPattern(",bb,cc");
        assertThat(result).isFalse();
        result = RacingCarView.checkPattern("aaa,bbb,");
        assertThat(result).isFalse();
    }

    @Test
    public void 자동차생성() {
        String[] names = RacingCarView.parseCarNames("aaa,bbb,ccc");
        List<Car> cars = RacingCarGame.createCars(names);
        assertThat(cars.size()).isEqualTo(3);
        assertThat(cars.get(0).getName()).isEqualTo("aaa");

        names = RacingCarView.parseCarNames("aaa,bbb");
        cars = RacingCarGame.createCars(names);
        assertThat(cars.size()).isEqualTo(2);
        assertThat(cars.get(0).getName()).isEqualTo("aaa");
    }

    @Test(expected = RuntimeException.class)
    public void 자동차생성에러() {
        String[] names = RacingCarView.parseCarNames("aaa,bbb,");
        List<Car> cars = RacingCarGame.createCars(names);
        assertThat(cars.size()).isEqualTo(0);

        names = RacingCarView.parseCarNames("aaa,bbb,");
        cars = RacingCarGame.createCars(names);
        assertThat(cars.size()).isEqualTo(0);
    }
}