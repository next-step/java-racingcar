package racingcar.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Position implements Comparable<Position> {

    public static final int DEFAULT_POSITION = 1;
    private static final Map<Integer,Position> CACHE = new HashMap<>();
    private int position;

    private Position(int position) {
        this.position = position;
    }

    public static Position create() {
        return getInstance(DEFAULT_POSITION);
    }

    public static Position valueOf(int position) {
        return getInstance(position);
    }

    private static Position getInstance(int position){
        if(!CACHE.containsKey(position)){
            CACHE.put(position, new Position(position));
        }
        return CACHE.get(position);
    }

    public static Position max() {
        Integer max = Collections.max(CACHE.keySet());
        return CACHE.get(max);
    }

    public Position incrementExact(){
        return valueOf(position + 1);
    }

    public int parseInt(){
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    @Override
    public int compareTo(Position other) {
        return Integer.compare(position, other.position);
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "Position{" + "position=" + position + '}';
    }
}