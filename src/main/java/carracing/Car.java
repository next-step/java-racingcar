package carracing;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Car {
    public int distance = 0;

    public void move() {
        int randomNum = getRandom();
        getMove(randomNum);
    }

    public void getMove(int randomNum) {
        if (randomNum > 3) {
            distance++;
        }
    }

    private int getRandom() {
        Random random = new Random();
        int randomNum = random.nextInt(10);
        return randomNum;
    }
}