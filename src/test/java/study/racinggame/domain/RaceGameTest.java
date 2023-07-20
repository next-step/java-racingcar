package study.racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.racinggame.domain.strategy.RandomMoveStrategy;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RaceGameTest {
    @Test
    @DisplayName(value = "Car 객체(들) 중에서 position 값이 가장 높은 객체가 우승자로 반환")
    void Car_객체_중에서_position_값이_가장_높은_객체가_우승자로_반환() {
        // given
        final Cars cars = new Cars(new Car[]{new Car(1, "푸바오"), new Car(3, "러바오"), new Car(3, "아이바오")});
        final RaceGame sut = new RaceGame(cars, 5, new RandomMoveStrategy());

        // when
        final List<String> expected = List.of("러바오", "아이바오");
        final List<Car> actual = sut.winners();

        //then
        assertTrue(actual.stream().allMatch(car -> expected.contains(car.getName())));
    }

}