package racinggame.domain;

import java.util.List;

public class Car {
    private static final int MAX_LENGTH = 5;
    private final String name;
    private int location;

    public Car(final String name) {
        this.name = name;
        this.location = 0;
    }

    public static Car of(final String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 자동차의 이름은 5자를 초과할 수 없습니다.");
        }
        return new Car(name);
    }

    public int getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public void moveForward() {
        this.location++;
    }

    public static boolean isLessThanMax (List<String> playerNameList) {
        for (String playerName : playerNameList) {
            if (playerName.length() > MAX_LENGTH) {
                System.out.println("[ERROR] 자동차의 이름은 5자를 초과할 수 없습니다.");
                return false;
            }
        }
        return true;
    }
}
