package racing;

public class Car {
    private static final int MOVE_CHECK_NUMBER = 4;
    private String name;
    private int distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }

    public void round() {
        int moveNum = getMoveRandomNumber();
        move(moveNum);
    }

    private void move(int moveNum) {
        if (moveNum >= MOVE_CHECK_NUMBER) {
            distance++;
        }
    }

    public static int getMoveRandomNumber() {
        return (int) ((Math.random() * (10)));
    }
}
