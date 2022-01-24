package racing;

public class Car {

    private final String name;
    private int distance;
    private final int MOVE_THRESHOLD;

    public Car(String name, int moveThreshold) {
        validateNameLength(name);
        this.name = name;
        this.distance = 0;
        this.MOVE_THRESHOLD = moveThreshold;
    }

    private void validateNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }

    public void printDistance() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < distance; i++) {
            sb.append('-');
        }
        System.out.println(name + " : " + sb);
    }

    public void move() {
        if (moveCheck()) {
            distance++;
        }
    }

    private boolean moveCheck() {
        int random = (int) ((Math.random() * (10)));
        return random >= MOVE_THRESHOLD;
    }
}