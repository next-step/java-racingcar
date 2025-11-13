package study.racing.domain;

public class Car {

    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        if (RandomMoveRule.isRandomNumber()) {
            this.position++;
        }
    }

    public boolean isEqualsMaxPosition(int maxPosition) {
        return this.position == maxPosition;
    }

    public int max(int maxPosition){
        return Math.max(maxPosition, this.getPosition());
    }

    public void moveToPosition(int position) {
        this.position = position;
    }
}
