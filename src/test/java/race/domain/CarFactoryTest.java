package race.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarFactoryTest {
//    @Test
//    void 자동차_리스트_생성() {
//        CarFactory carFactory = new CarFactory();
//        int carCount = 1;
//        List<Car> carList = carFactory.createCars(carCount);
//        assertThat(carList).hasSize(1);
//    }

    @Test
    void split() {
        CarFactory carFactory = new CarFactory();
        List<String> value = carFactory.splitName("pobi,nana,kai");
        assertThat(value).contains("pobi");
        assertThat(value).containsExactly("pobi","nana","kai");
    }

    @Test
    void 자동차_이름_길이_성공() {
        CarFactory carFactory = new CarFactory();
        String name = "abcde";
        assertThat(carFactory.checkNameLength(name)).isTrue();
    }

    @Test
    void 자동차_이름_길이_실패() {
        CarFactory carFactory = new CarFactory();
        String name = "abcdef";
        assertThat(carFactory.checkNameLength(name)).isFalse();
    }

}
