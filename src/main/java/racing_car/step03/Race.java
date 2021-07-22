package racing_car.step03;

import java.util.Arrays;
import java.util.Random;

public class Race {
    private Random r = new Random();
    private final int MIN_NUMBER = 4;
    private String[] cars;

    public void execute(int count, int attempt) {
        cars = new String[count];
        Arrays.fill(cars, "");
        StringBuilder sb = new StringBuilder();
         race(cars,sb,attempt);

    }

    private void race(String[] cars ,StringBuilder sb, int attempt) {
        if (attempt<=0) return;
        sb = sb.append("\n");
        attempt -=1;
        race(cars,sb,attempt);
    }

    private boolean move(int random) {
        if (random >= MIN_NUMBER) return true;

        return false;
    }
}
