package racing.service;

import org.junit.Test;
import racing.domain.Car;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MakeTest {

    @Test
    public void 정규식() {
        boolean result = RacingCarMake.checkPattern("abc,asdf,erwe");
        assertThat(result).isTrue();
        result = RacingCarMake.checkPattern("a,b,c,d,e");
        assertThat(result).isTrue();
        result = RacingCarMake.checkPattern("a,b");
        assertThat(result).isTrue();
        result = RacingCarMake.checkPattern(" a,b");
        assertThat(result).isTrue();
        result = RacingCarMake.checkPattern(" a,b ");
        assertThat(result).isTrue();
        result = RacingCarMake.checkPattern("  a,b  ");
        assertThat(result).isTrue();
    }

    @Test(expected = RuntimeException.class)
    public void 정규식에러() {
        boolean result;
        result = RacingCarMake.checkPattern(",bb,cc");
        assertThat(result).isFalse();
        result = RacingCarMake.checkPattern("aaa,bbb,");
        assertThat(result).isFalse();
    }

    @Test
    public void 자동차생성() {
        String[] names = RacingCarMake.parseCarNames("aaa,bbb,ccc");
        List<Car> cars = RacingCarMake.getCars(names);
        assertThat(cars.size()).isEqualTo(3);
        assertThat(cars.get(0).getName()).isEqualTo("aaa");

        names = RacingCarMake.parseCarNames("aaa,bbb");
        cars = RacingCarMake.getCars(names);
        assertThat(cars.size()).isEqualTo(2);
        assertThat(cars.get(0).getName()).isEqualTo("aaa");
    }

    @Test(expected = RuntimeException.class)
    public void 자동차생성에러() {
        String[] names = RacingCarMake.parseCarNames("aaa,bbb,");
        List<Car> cars = RacingCarMake.getCars(names);
        assertThat(cars.size()).isEqualTo(0);

        names = RacingCarMake.parseCarNames("aaa,bbb,");
        cars = RacingCarMake.getCars(names);
        assertThat(cars.size()).isEqualTo(0);
    }
}