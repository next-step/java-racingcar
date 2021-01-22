package racingcar;

import lombok.Getter;

@Getter
public class Car {

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void updatePosition() {
        this.position++;
    }

    public void printCarState() {
        System.out.print(name + " : ");
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
