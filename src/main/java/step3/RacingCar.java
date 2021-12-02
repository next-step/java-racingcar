package step3;

public class RacingCar {
    private RamdomCondition ramdomCondition;

    private int distance = 0;
    private Name name;

    public RacingCar() {
        this.ramdomCondition = new RamdomCondition();
    }

    public RacingCar(String name) {
        this();
        this.name = new Name(name);
    }

    public boolean isMove(RamdomCondition ramdomCondition) {
        return ramdomCondition.meet();
    }

    //삭제 예정
    public boolean isMove() {
        return this.ramdomCondition.meet();
    }

    public void move(RamdomCondition ramdomCondition) {
        if (isMove(ramdomCondition)) {
            this.distance++;
        }
    }

    public void move() {
        if (isMove()) {
            this.distance++;
        }
    }

    public int getDistance() {
        return this.distance;
    }

    public Name getName() {
        return this.name;
    }


}
