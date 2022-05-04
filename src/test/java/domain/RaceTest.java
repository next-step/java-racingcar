package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RaceTest {

    List<Car> mockCars = new LinkedList<>();
    List<Car> winners = new LinkedList<>();
    Car mockCar1;
    Car mockCar2;
    Car mockCar3;
    Car mockCar4;
    Car mockCar5;

    @BeforeEach
    void setUp() {
        mockCar1 = new Car("Tayo", new StringBuilder("---"), 3);
        mockCar2 = new Car("Dodo", new StringBuilder("------"), 6);
        mockCar3 = new Car("Poco", new StringBuilder("-"), 1);
        mockCar4 = new Car("Redd", new StringBuilder("----"), 4);
        mockCar5 = new Car("Frodo", new StringBuilder("------"), 6);

        mockCars.add(mockCar1);
        mockCars.add(mockCar2);
        mockCars.add(mockCar3);
        mockCars.add(mockCar4);
    }

    @Test
    public void 우승자_한명_출력() {
        winners.add(mockCar2);
        assertThat(Race.getWinner(mockCars)).isEqualTo(winners);
    }

    @Test
    public void 여러_우승자_출력() {
        mockCars.add(mockCar5);

        winners.add(mockCar2);
        winners.add(mockCar5);
        assertThat(Race.getWinner(mockCars)).isEqualTo(winners);
    }
}