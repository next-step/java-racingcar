package racing.domain;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Car {

    private final Name name;

    private final Position position;

    public Car(String name, int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public Car(String name) {
        this(name, 0);
    }

    public Name getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    public void move() {
        position.move();
    }

    public void rank(Map<Integer, List<String>> rankings) {
        List<String> names =
                rankings.computeIfAbsent(position.getPosition(), name -> new LinkedList<>());
        names.add(name.getName());
    }
}
