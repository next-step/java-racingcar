package step3;

public class Car {
    private final int CRITERION_NUMBER = 4;
    private String distance = "";

    public void moveIf(int num) {
        if (num > CRITERION_NUMBER) move();
    }

    private void move() {
        this.distance += "-";
    }

    public void show() {
        System.out.println(distance);
    }
}
