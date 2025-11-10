package study.racing.domain;

public class Car {

    private String name;
    private String position;

    public Car(String name, String position) {
        nameValidate(name);
        this.name = name;
        this.position = position;
    }

    private static void nameValidate(String name) {
        if (isBlank(name)) {
            throw new RuntimeException("자동차 이름은 5자를 초과할 수 앖습니다.");
        }
    }

    private static boolean isBlank(String name) {
        return name.length() > 5 || name.isEmpty();
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

}
