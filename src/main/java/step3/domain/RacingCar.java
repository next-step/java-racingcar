package step3.domain;

public class RacingCar {

    private RacingCarRule rule = new RacingCarRule();
    private int distance = 0;
    private String name;

    public RacingCar(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이하로 입력가능합니다.");
        }
        this.name = name;
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }

    public void move(NumberGenerator numberGenerator) {
        int movingCondition = numberGenerator.generate();
        if (rule.canMove(movingCondition)) {
            distance += 1;
        }
    }

}
