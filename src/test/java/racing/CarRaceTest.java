package racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CarRaceTest {
    final private List<Car> cars = new ArrayList<Car>();
    final private CarRace carRace = new CarRace();

    final private Car car1 = new Car("Tommy", 8);
    final private Car car2 = new Car("Tammy", 14);
    final private Car car3 = new Car("Bear", 4);
    final private Car car4 = new Car("Tonny", 14);

    @BeforeEach
    void init() {
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
    }

    @Test
    @DisplayName("자동차 이름을 입력 받는다.")
    void enterCarName() {
        String entry = "Tommy,bear,Bear,tommy,ToMmy";

        List<String> carEntry = Stream.of(entry.split(",")).collect(Collectors.toList());

        Assertions.assertThat(carEntry.get(0)).isEqualTo("Tommy");
        Assertions.assertThat(carEntry.get(1)).isEqualTo("bear");
        Assertions.assertThat(carEntry.get(2)).isEqualTo("Bear");
        Assertions.assertThat(carEntry.get(3)).isEqualTo("tommy");
        Assertions.assertThat(carEntry.get(4)).isEqualTo("ToMmy");
        Assertions.assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    carEntry.get(5);
                });
    }

    @Test
    @DisplayName("랜덤값 확인한다.")
    void getRandomNumber() {
        Random random = new Random();

        for (int i = 0; i < 100000; i++) {
            Assertions.assertThat(random.nextInt(9)).isBetween(0, 9);
        }
    }

    @Test
    @DisplayName("전진하고 전진한만큼 출력이 잘 되는지 확인한다.")
    void racing() {
        carRace.racing();
    }

    @Test
    @DisplayName("우승자의 전진한 거리를 구한다.")
    void getWinnerMaxPosition() {
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);

        Comparator<Car> comparatorByPosition = Comparator.comparingInt(Car::getPosition);
        Assertions.assertThat(cars.stream().max(comparatorByPosition).orElseThrow().getPosition()).isEqualTo(14);
    }

    @Test
    @DisplayName("우승자를 정한다.")
    void getWinners() {
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);

        Assertions.assertThat(
                cars.stream()
                        .filter(p -> p.getPosition() == 14)
                        .collect(Collectors.toList()).get(0).getName()).isEqualTo("Tammy");

        Assertions.assertThat(
                cars.stream()
                        .filter(p -> p.getPosition() == 14)
                        .collect(Collectors.toList()).get(1).getName()).isEqualTo("Tonny");
    }
}