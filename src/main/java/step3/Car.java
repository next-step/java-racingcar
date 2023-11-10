package step3;

public class Car {
    private String name;
    private int position;

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String name() {
        return name;
    }

    public int position() {
        return position;
    }

    public void move(int randomValue, int decisionValue) {
        if(randomValue>=decisionValue) position++;
    }
}
