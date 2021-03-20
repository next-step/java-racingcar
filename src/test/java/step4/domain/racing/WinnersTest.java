package step4.domain.racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.domain.car.Car;
import step4.domain.car.name.Name;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WinnersTest {

    private List<Car> cars;

    @BeforeEach
    void setUp() {
        cars = new ArrayList<>();
        cars.add(new Car("one"));
        cars.add(new Car("two"));
    }

    @DisplayName("Winners 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // when
        Winners actualWinners = new Winners(cars);
        Winners expectedWinners = new Winners(cars);

        // then
        assertThat(actualWinners).isEqualTo(expectedWinners);

    }

    @DisplayName("Winners 인스턴스가 소유한 데이터 반환 여부 테스트")
    @Test
    void 반환() {
        // given
        Winners winners = new Winners(cars);

        // when
        List<Car> actual = winners.winners();

        // then
        assertThat(actual).isEqualTo(cars);
    }

}