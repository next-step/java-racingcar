package study.racing;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Car {
    private static int MAX_RANDOM_INT = 10;
    private static String FORWARD_STRING = "-";
    private int position;

    public int getRandomInt() {
        Random ran = new Random();
        return ran.nextInt(MAX_RANDOM_INT);
    }

    public void move(int randomInt){
        if(randomInt >= 4){
            this.position++;
        }
    }


    @Override
    public String toString() {
        return IntStream.range(0, position)
                .mapToObj(i -> FORWARD_STRING)
                .collect(Collectors.joining());
    }


}
