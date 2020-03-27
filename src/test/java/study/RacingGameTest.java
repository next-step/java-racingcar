package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

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

        for (int i = 0; i < 3; i++) {
            cars[i] = new Car(i, i+"번째");
        }
        carNames = new String[3];
        carNames[0] = "pobi";
        carNames[1] = "crong";
        carNames[2] = "hox";
    }

    @Test
    public void move() {
        Random random = new Random();

        for (int i = 0; i < cars.length; i++) {
            cars[i].moveForward();
        }

        assertThat(cars[0].getPosition()).isEqualTo(1);
    }

    @Test
    public void showWinner() {
        assertThat(new GameProgress().showWinner(new RacingGame(carNames, 3))).isEqualTo("pobi,crong,hox");
    }



}
