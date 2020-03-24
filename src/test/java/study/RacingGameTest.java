package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    int count;
    int time;
    Car[] cars;

    private final int BASE_POINT = 4;
    private final int RANDOM_BOUND = 10;
    private final int DISTANCE = 1;
    private final int ZERO = 0;
    private final String SPLIT_CHAR = ",";

    public class Car {

        private int position;
        private String name;
        public Car(int position, String name) {
            this.position = position;
            this.name = name;
        }

        public int getPosition() {
            return position;
        }

        public void setPosition(int position) {
            this.position = position;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    @BeforeEach
    void setUp() {
        count = 3;
        time = 5;

        cars = new Car[3];

        for (int i = 0; i < 3; i++) {
            cars[i] = new Car(i, i+"번째");
        }
    }

    @Test
    public void move() {
        Random random = new Random();

        for (int i = 0; i < cars.length; i++) {
            //int ranCount = random.nextInt(RANDOM_BOUND);
            int ranCount = 4;
            int position = cars[i].getPosition();
            cars[i].setPosition( position += (ranCount >= BASE_POINT) ? DISTANCE : ZERO);
        }

        assertThat(cars[0].getPosition()).isEqualTo(1);
    }

    @Test
    public void showWinner() {
        int max = 0;
        for (int i = 0; i < cars.length; i++) {
            max = Math.max(cars[i].getPosition(), max);
        }

        String winners = "";
        for (int i = 0; i < cars.length; i++) {
            winners += (cars[i].getPosition() == max) ? cars[i].getName() + SPLIT_CHAR : "";
        }

        winners = winners.substring(0, winners.length() - 1);
        assertThat(winners).isEqualTo("2번째");
    }



}
