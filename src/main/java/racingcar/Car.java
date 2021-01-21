package racingcar;

public class Car {
    private final String name;
    private int location;

    public Car(String name, int initialLocation) {
        this.name = name;
        this.location = initialLocation;
    }

    public String getName() {
        return this.name;
    }

    public int getLocation() {
        return this.location;
    }

    public void play(MoveChecker moveChecker) {
        if (moveChecker.isMoving()) {
            this.location++;
        }
    }

    public void printNameAndCurrentPosition() {
        System.out.print(this.name + " : ");
        for (int i = 0; i < this.location; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
