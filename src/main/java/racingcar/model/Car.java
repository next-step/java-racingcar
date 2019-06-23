package racingcar.model;

import racingcar.utils.NumGenerator;

public class Car {
    private final int GO_CONDITION = 4;
    private String name;
    private int position;
    private NumGenerator numGenerator;

    private Car() {
    }

    public Car(String name, int position, NumGenerator numGenerator) {
        this.name = name;
        this.position = position;
        this.numGenerator = numGenerator;

    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public void setNumGenerator(NumGenerator numGenerator) {
        this.numGenerator = numGenerator;

    }

    public int getNumGenerator() {
        return numGenerator.nextInt();
    }

    public void move() {
        if (getNumGenerator() > GO_CONDITION) {
            this.position++;
        }
    }
}
