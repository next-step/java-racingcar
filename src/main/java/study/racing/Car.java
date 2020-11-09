package study.racing;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Car {

    private static final String FORWARD_STRING = "-";
    private static final int INITIAL_POSITION = 0;

    private int position;

    public Car(){
        this.position = INITIAL_POSITION;
    }


    public void move(RacingMoveStrategy racingMoveStrategy){
        position += racingMoveStrategy.getMovement();
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
