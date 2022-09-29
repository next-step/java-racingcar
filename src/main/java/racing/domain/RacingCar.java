package racing.domain;

public class RacingCar {

    public static final int DEFAULT = 0;

    private CarName name;
    private int position;

    public RacingCar(final CarName carName, final int position) {

        this.name = carName;
        this.position = position;
    }

    public RacingCar(final CarName carName) {

        this(carName, DEFAULT);
    }

    public void move() {

        this.position++;
    }

    public CarName getName() {

        return this.name;
    }

    public int getPosition() {

        return this.position;
    }

    public String extracted() {

        return this.getName().getCarName() + " : " + convert(this.position);
    }

    private String convert(final int position) {

        final StringBuilder result = new StringBuilder();
        for (int i = 0; i < position; i++) {
            result.append("-");
        }
        return result.toString();
    }
}