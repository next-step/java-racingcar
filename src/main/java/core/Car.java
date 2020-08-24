package core;

import java.util.Objects;

public class Car implements Comparable<Car> {
    private static final int DEFAULT_POSITION = 0;
    private static final int CARNAME_MAX_LENGTH = 5;

    public String name;
    public int position;

    private Car(String carName) {
        this.name = carName;
        this.position = DEFAULT_POSITION;
    }

    public static Car create(String carName) {
        return new Car(carName);
    }

    public static void validate(String carName) {
        if(Objects.isNull(carName) || carName.isEmpty() || carName.length() > CARNAME_MAX_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public void carAction(MoveStrategy moveStrategy) {
        if(moveStrategy.isMove()) {
            position++;
        }
    }

    @Override
    public int compareTo(Car o) {
        return  this.position < o.position ? 1 :
                this.position > o.position ? -1 :
                        0;
    }

}
