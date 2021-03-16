package step3;

public class CarPosition {
    private final String carName;
    private final int position;

    public static class Builder {
        private String carName;
        private int position;

        public Builder carName(String val) {
            carName = val;
            return this;
        }

        public Builder position(int val) {
            position = val;
            return this;
        }

        public CarPosition build() {
            return new CarPosition(carName, position);
        }
    }

    private CarPosition(String carName, int position) {
        this.carName = carName;
        this.position = position;
    }

    public String getCarName() {
        return this.carName;
    }

    public int getPosition() {
        return this.position;
    }
}
