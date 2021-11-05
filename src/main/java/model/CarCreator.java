package model;

import java.util.*;

public class CarCreator {

    private CarCreator() {}

    public static List<Car> create(int count) {
        return Collections.nCopies(count, new Car());
    }
}
