package racing;

import java.util.ArrayList;
import java.util.List;

public class Car {

    private static final int GO_CONDITION = 4;

    private int position = 1;
    private String name;

    public Car() {
    }

    public Car(String name) {
        if (name.trim().length() > 5) {
            throw new IllegalStateException("자동차 이름은 5자를 초과할 수 없다.");
        }
        this.name = name.trim();
    }

    public Car(String name, int position) {
        this(name);
        this.position = position;
    }

    public static List<Car> findWinners(List<Car> cars) {
        int maxPosition = 1;
        List<Car> winners = new ArrayList<>();

        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
                winners.clear();
                winners.add(car);
            } else if (car.getPosition() == maxPosition) {
                winners.add(car);
            }
        }
        return winners;
    }

    public void move(int randomNumber) {
        if (randomNumber >= GO_CONDITION) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
