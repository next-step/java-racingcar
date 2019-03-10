package racing;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarTest {

    @Test
    public void 정규식() {
        boolean result = RacingCarUtils.checkPattern("abc,asdf,erwe");
        assertThat(result).isTrue();
        result = RacingCarUtils.checkPattern("a,b,c,d,e");
        assertThat(result).isTrue();
        result = RacingCarUtils.checkPattern("a,b");
        assertThat(result).isTrue();
        result = RacingCarUtils.checkPattern(" aa,bb,cc");
        assertThat(result).isFalse();
        result = RacingCarUtils.checkPattern("aaa,bbb,");
        assertThat(result).isFalse();
    }

    @Test
    public void 자동차생성() {
        String[] names = RacingCarUtils.splitText("aaa,bbb,ccc");
        List<Car> cars = RacingCarUtils.getCars(names);
        assertThat(cars.size()).isEqualTo(3);
        assertThat(cars.get(0).getName()).isEqualTo("aaa");
    }

    @Test
    public void 자동차가이번에움직였나() {
        Car car = new Car();
        assertThat(car.getMoveCount(4)).isEqualTo(0);
        assertThat(car.getMoveCount(5)).isEqualTo(1);
    }

    @Test
    public void 랜덤값가져오기() {
        Car car = new Car();
        assertThat(car.getRandomValue()).isLessThan(10);
        assertThat(car.getRandomValue()).isGreaterThanOrEqualTo(0);
    }


}