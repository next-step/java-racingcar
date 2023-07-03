package racing.domain;

public class Car {

    private String name;
    private int criterion;
    private int position;

    public Car(String name) {
        this.name = name;
        this.criterion = 4;
        this.position = 1;
    }

    public Car(String name, int criterion) {
        this.name = name;
        this.criterion = criterion;
        this.position = 1;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public void moveOneStepMoreThanCriterion(int value) {
        if (value >= this.criterion) {
            this.position++;
        }
    }

}
