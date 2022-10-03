package racingcar.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Distances implements Iterable<Distance> {
    private static final Distance NOT_EXIST = new Distance("");
    
    private final List<Distance> distances;

    public Distances() {
        distances = new ArrayList<>();
    }

    public Distances(List<Distance> distances) {
        this.distances = distances;
    }

    public void add(Distance distance) {
        distances.add(distance);
    }

    public Distances longest() {
        List<Distance> result = new ArrayList<>();
        Distance longest = NOT_EXIST;
        for (Distance distance : distances) {
            if (distance.equals(longest)) {
                result.add(distance);
            }
            
            if (distance.greaterThan(longest)) {
                result = new ArrayList<>();
                result.add(distance);
                longest = distance;
            }
        }
        return new Distances(result);
    }

    public List<String> names() {
        List<String> names = new ArrayList<>();
        for (Distance distance : distances) {
            names.add(distance.getCarName());
        }
        return names;
    }

    @Override
    public Iterator<Distance> iterator() {
        return distances.iterator();
    }

    @Override
    public void forEach(Consumer action) {
        for (Distance distance : distances) {
            action.accept(distance);
        }
    }

    @Override
    public Spliterator<Distance> spliterator() {
        return distances.spliterator();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        Distances other = (Distances) o;
        return Objects.equals(distances, other.distances);
    }

    @Override
    public int hashCode() {
        return Objects.hash(distances);
    }
}
