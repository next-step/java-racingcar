package racing.view;

public class RacingCarView {
    private String carName;
    private int position;

    public RacingCarView(String name, int position) {
        this.carName = name;
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public String getCarName() {
        return carName;
    }
}