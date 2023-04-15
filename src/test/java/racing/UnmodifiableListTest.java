package racing;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class UnmodifiableListTest {
    @Test
    void unmodifiableList_수정시_에러() {
        int carCount = 3;
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }

        List<Car> unmodifiableCars = Collections.unmodifiableList(cars);
        assertThatThrownBy(() -> unmodifiableCars.set(0, new Car()))
                .isInstanceOf(UnsupportedOperationException.class);
        assertThatNoException().isThrownBy(() -> cars.set(0, new Car()));
    }

    @Test
    void unmodifiableList_원본_변경시_변경된다() {
        List<Integer> originalList = new ArrayList<>();
        originalList.add(1);
        originalList.add(2);
        originalList.add(3);
        List<Integer> unmodifiableList = Collections.unmodifiableList(originalList);
        originalList.set(0, 4);

        assertThat(unmodifiableList.get(0)).isEqualTo(4);
    }

    @Test
    void 방어적_복사시_원본_리스트_참조는_끊긴다() {
        List<Integer> originalList = new ArrayList<>();
        originalList.add(1);
        originalList.add(2);
        originalList.add(3);
        List<Integer> copiedList = new ArrayList<>(originalList);
        originalList.set(0, 4);

        assertThat(copiedList.get(0)).isEqualTo(1);
    }

    @Test
    void 방어적_복사시_내부_객체는_공유된다() {
        List<TestCar> originalList = new ArrayList<>();
        TestCar car1 = new TestCar("1");
        originalList.add(car1);
        List<TestCar> copiedList = new ArrayList<>(originalList);
        car1.name = "2";

        assertThat(copiedList.get(0).name).isEqualTo("2");
    }

    class TestCar {
        public String name;

        public TestCar(String name) {
            this.name = name;
        }
    }
}
