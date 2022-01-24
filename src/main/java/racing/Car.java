package racing;

public class Car {

    private final String name;
    private int distance;
    private final int NAME_LENGTH_CONDITION;
    private final int MOVE_CONDITION;

    public Car(String name, int nameLengthCondition, int moveCondition) {
        this.name = name;
        this.distance = 0;
        this.NAME_LENGTH_CONDITION = nameLengthCondition;
        this.MOVE_CONDITION = moveCondition;
        validateNameLength(name);
    }

    private void validateNameLength(String name) {
        if (name.length() > NAME_LENGTH_CONDITION) {
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
        return random >= MOVE_CONDITION;
    }
}