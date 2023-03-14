package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class CarRaceTest {
    private final List<Car> cars = new ArrayList<>();

    private final Car car1 = new Car("Tommy", new Position(8));
    private final Car car2 = new Car("Tammy", new Position(14));
    private final Car car3 = new Car("Bear", new Position(4));
    private final Car car4 = new Car("Tonny", new Position(14));

    @BeforeEach
    void init() {
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
    }

    @Test
    @DisplayName("입력 받은 자동차 이름을 쉼표(,)로 구분한다.")
    void enterCarName() {
        String entry = "Tommy,bear,Bear,tommy,ToMmy";

        List<String> carEntry = Stream.of(entry.split(",")).collect(Collectors.toList());

        assertThat(carEntry.get(0)).isEqualTo("Tommy");
        assertThat(carEntry.get(1)).isEqualTo("bear");
        assertThat(carEntry.get(2)).isEqualTo("Bear");
        assertThat(carEntry.get(3)).isEqualTo("tommy");
        assertThat(carEntry.get(4)).isEqualTo("ToMmy");
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    carEntry.get(5);
                });
    }

    @Test
    @DisplayName("랜덤값 확인한다.")
    void getRandomNumber() {
        Random random = new Random();

        for (int i = 0; i < 100000; i++) {
            assertThat(random.nextInt(9)).isBetween(0, 9);
        }
    }

    @Test
    @DisplayName("우승자의 전진한 거리를 구한다.")
    void getWinnerMaxPosition() {
        int maxPosition;

        Comparator<Car> comparatorByPosition = Comparator.comparingInt(Car::getPosition);

        maxPosition = cars.stream().max(comparatorByPosition).orElseThrow().getPosition();

        assertThat(maxPosition).isEqualTo(14);
    }

    @Test
    @DisplayName("가장 많이 전진한 자동차가 우승자이다.")
    void getWinners() {
        assertThat(
                cars.stream()
                        .filter(p -> p.getPosition() == 14)
                        .collect(Collectors.toList()).get(0).getName()).isEqualTo("Tammy");

        assertThat(
                cars.stream()
                        .filter(p -> p.getPosition() == 14)
                        .collect(Collectors.toList()).get(1).getName()).isEqualTo("Tonny");


    }
}