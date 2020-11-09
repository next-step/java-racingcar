package study.racing;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Car {
    private static final int MAX_RANDOM_INT = 10;
    private static final String FORWARD_STRING = "-";
    private static final int INITIAL_POSITION = 0;

    private int position;

    public Car(){
        this.position = INITIAL_POSITION;
    }

    public int getRandomInt() {
        Random ran = new Random();
        return ran.nextInt(MAX_RANDOM_INT);
    }

    public void move(int randomInt){
        if(randomInt >= 4){
            position++;
        }
    }


    @Override
    public String toString() {
        return IntStream.range(0, position)
                .mapToObj(i -> FORWARD_STRING)
                .collect(Collectors.joining());
    }


    public Integer getPosition() {
        return position;
    }
}
