package racingCar.domain.car;

public class RacingCar {
    private final String name;
    private int position;

    public RacingCar(String name) {
        this(name, 0);
    }

    public RacingCar(String name,int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(boolean isMove) {
        if(isMove) {
            position++;
        }
    }
}
