package carracing;

import java.lang.reflect.AnnotatedType;
import java.util.*;

public class Car {
    private String distance = "";

    public String distance() {
        return distance;
    }

    public void move() {
        int randomNum = random();
        if(randomNum > 3) {
            distance += '-';
        }
    }

    public int random() {
        Random random = new Random();
        int randomNum = random.nextInt(10);
        return randomNum;
    }
}