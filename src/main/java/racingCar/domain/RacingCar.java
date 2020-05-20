package racingCar.domain;

public class RacingCar implements Comparable<RacingCar> {
    private final String name;
    private int position;

    public RacingCar(String name) {
        this.name = name;
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

    @Override
    public int compareTo(RacingCar o) {
        return Integer.compare(o.getPosition(), this.getPosition());
    }
}
