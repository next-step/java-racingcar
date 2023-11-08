package racing;

import java.util.List;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class Car {

    public static final int NAME_LIMIT = 5;

    private String name;
    private int distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public Car() {
    }

    public String carName() { return  name; }

    public int carDistance() {
        return distance;
    }

    public Boolean equalDistance(int distance) {
        if (this.distance == distance) return TRUE;
        return FALSE;
    }

    public static Boolean lengthCheck(String[] names) {
        for (String name : names) {
            if (count(name) == FALSE) return FALSE;
        }
        return TRUE;
    }

    private static Boolean count(String name) {
        if (name.length() > NAME_LIMIT) {
            System.out.println("자동차 이름은 5자 이하로 입력하세요.");
            return FALSE;
        }
        return TRUE;
    }

    public void race(List<Car> cars, int trials) {
        for (int i = 0; i < trials; i++) {
            drive(cars);
            newLine();
        }
    }

    private void drive(List<Car> cars) {
        cars.forEach(car -> {
            car.move(new RandomMoveCondition());
            car.status();
        });
    }

    public void move(MoveCondition moveCondition) {
        if (moveCondition.move()) {
            distance += 1;
        }
    }

    public void status() {
        StringBuilder status = new StringBuilder();
        for (int i = 0; i < carDistance(); i++) {
            status.append("-");
        }
        System.out.println(carName() + ": " + status);
    }

    private void newLine() {
        System.out.println();
    }
}
