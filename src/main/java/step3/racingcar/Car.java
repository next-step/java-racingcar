package step3.racingcar;

public class Car {
    private MovableStrategy movableStrategy;
    private String place = "";
    private static final int NEED_POWER = 4;

    private boolean isEnough(int power) {
        return NEED_POWER <= power;
    }

    public void move() {
        if (isEnough(movableStrategy.move())) {
          axel();
        }
        printPlace();
    }

    private void axel() {
        place += "-";
    }

    private void printPlace() {
        System.out.println(this.place);
    }

    public void setMovableStrategy(MovableStrategy movableStrategy){
        this.movableStrategy = movableStrategy;
    }
}
