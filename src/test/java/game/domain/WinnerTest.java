package game.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnerTest {

    Car car1;
    Car car2;
    Car car3;
    Car car4;

    @BeforeEach
    void setUp() {
        car1 = new Car("test1", 1);
        car2 = new Car("test2", 4);
        car3 = new Car("test3", 1);
        car4 = new Car("test4", 4);
    }

    @Test
    @DisplayName("우승자 한 명")
    void single_winner() {
        String winners = new Winner().getWinners(List.of(car1, car2, car3));
        assertThat(winners).isEqualTo("test2");
    }

    @Test
    @DisplayName("우승자가 여러 명이 나온다")
    void multiple_winner() {
        String winners = new Winner().getWinners(List.of(car1, car2, car3, car4));
        assertThat(winners).isEqualTo("test2, test4");
    }
}