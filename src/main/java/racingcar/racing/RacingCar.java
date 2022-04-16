package racingcar.racing;

public class RacingCar implements Movable {
    private static final int FORWARD_CONDITION = 4;
    private final int id;

    private int xCoordinate;


    public RacingCar(int id, int xCoordinate) {
        this.id = id;
        this.xCoordinate = xCoordinate;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public int getId() {
        return id;
    }

    @Override
    public void forward(int value) {
        if(value > FORWARD_CONDITION) {
            xCoordinate++;
        }
    }

}
