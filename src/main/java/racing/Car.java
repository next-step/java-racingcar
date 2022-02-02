package racing;

public class Car implements Comparable<Car> {

    private static final int NAME_LENGTH_CONDITION = 5;

    private final String name;
    private final MoveRule rule;
    private int distance;

    public Car(String name, MoveRule rule) {
        this(name, 0, rule);
    }

    public Car(String name, int distance, MoveRule rule) {
        this.name = name;
        this.distance = distance;
        this.rule = rule;
        validateNameLength(name);
    }

    private void validateNameLength(String name) {
        if (name.length() > NAME_LENGTH_CONDITION) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }

    public void moveByRule() {
        if(moveCheck()) {
            distance++;
        }
    }

    private boolean moveCheck() {
        return rule.makeValue() >= rule.getMoveCondition();
    }

    @Override
    public int compareTo(Car o) {
        return o.distance - this.distance;
    }

    public boolean isSameDistance(int bestDistance) {
        return distance == bestDistance;
    }

    public String getStringDistance() {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < distance; i++) {
            sb.append('-');
        }
        return name + " : " + sb + "\n";
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }
}
