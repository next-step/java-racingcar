package step3to5.domain;

public class Car {
    private int score = 0;
    private final String name;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setScore() {
        score += 1;
    }
}
