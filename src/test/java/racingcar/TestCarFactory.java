package racingcar;

import java.util.List;

public class TestCarFactory {

    public static List<Car> createList(int count) {
        String[] names = new String[count];

        for (int i = 0; i < count; i++) {
            names[i] = generateName(i);
        }

        return CarFactory.create(names);
    }

    private static String generateName(int index) {
        return "car" + index;
    }
}
