package step3.logic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    @DisplayName("차동차 객체 생성 테스트")
    public void makeCarMove() {
//        List<Car> cars = Stream.generate(Car::new)
//                .limit(4)
//                .collect(Collectors.toList());
//
//        assertThat(cars.size()).isEqualTo(4);
    }
}