package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import domain.Car;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    int count;
    int time;
    Car[] cars;

    String[] carNames;

    private final int BASE_POINT = 4;
    private final int RANDOM_BOUND = 10;
    private final int DISTANCE = 1;
    private final int ZERO = 0;
    private final String SPLIT_CHAR = ",";

    @BeforeEach
    void setUp() {
        count = 3;
        time = 5;

        cars = new Car[3];

        cars[0] = new Car("pobi");
        cars[1] = new Car("crong");
        cars[2] = new Car("hox");
        carNames = new String[3];
        carNames[0] = "pobi";
        carNames[1] = "crong";
        carNames[2] = "hox";
    }

    @Test
    void moveForwardTest() {
        cars[0].moveForward(4);
        assertThat(cars[0].getPosition()).isEqualTo(1);
    }



}
