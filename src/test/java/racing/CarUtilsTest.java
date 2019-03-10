package racing;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarUtilsTest {

    @Test
    public void 정규식() {
        boolean result = RacingCarUtils.checkPattern("abc,asdf,erwe");
        assertThat(result).isTrue();
        result = RacingCarUtils.checkPattern("a,b,c,d,e");
        assertThat(result).isTrue();
        result = RacingCarUtils.checkPattern("a,b");
        assertThat(result).isTrue();
    }

    @Test(expected = RuntimeException.class)
    public void 정규식에러() {
        boolean result;
        result = RacingCarUtils.checkPattern(" aa,bb,cc");
        assertThat(result).isFalse();
        result = RacingCarUtils.checkPattern("aaa,bbb,");
        assertThat(result).isFalse();
    }

    @Test
    public void 자동차생성() {
        String[] names = RacingCarUtils.parseCarNames("aaa,bbb,ccc");
        List<Car> cars = RacingCarUtils.getCars(names);
        assertThat(cars.size()).isEqualTo(3);
        assertThat(cars.get(0).getName()).isEqualTo("aaa");

        names = RacingCarUtils.parseCarNames("aaa,bbb");
        cars = RacingCarUtils.getCars(names);
        assertThat(cars.size()).isEqualTo(2);
        assertThat(cars.get(0).getName()).isEqualTo("aaa");
    }

    @Test(expected = RuntimeException.class)
    public void 자동차생성에러() {
        String[] names = RacingCarUtils.parseCarNames("aaa,bbb,");
        List<Car> cars = RacingCarUtils.getCars(names);
        assertThat(cars.size()).isEqualTo(0);

        names = RacingCarUtils.parseCarNames("aaa,bbb,");
        cars = RacingCarUtils.getCars(names);
        assertThat(cars.size()).isEqualTo(0);
    }

    @Test
    public void 자동차정렬() {
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");

        car1.move(5);
        car2.move(5);
        car3.move(5);

        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        RacingCarUtils.sortCars(cars);

        assertThat(cars.get(0).getTotalDistance()).isGreaterThanOrEqualTo(cars.get(1).getTotalDistance());
        assertThat(cars.get(0).getTotalDistance()).isGreaterThanOrEqualTo(cars.get(2).getTotalDistance());
        assertThat(cars.get(1).getTotalDistance()).isGreaterThanOrEqualTo(cars.get(2).getTotalDistance());
    }

    @Test
    public void 자동차랭킹() {
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");

        car1.move(5);
        car2.move(5);
        car3.move(5);

        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        RacingCarUtils.sortCars(cars);

        List<Car> winners = RacingCarUtils.rankCars(cars);

        assertThat(winners.get(0).getTotalDistance()).isGreaterThanOrEqualTo(cars.get(0).getTotalDistance());
        assertThat(winners.get(0).getTotalDistance()).isGreaterThanOrEqualTo(cars.get(1).getTotalDistance());
        assertThat(winners.get(0).getTotalDistance()).isGreaterThanOrEqualTo(cars.get(2).getTotalDistance());
    }
}