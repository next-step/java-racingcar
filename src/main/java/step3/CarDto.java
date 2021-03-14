package step3;

public class CarDto {
    private String carName;
    private int position;

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

        public CarDto build() {
            return new CarDto(this);
        }
    }

    private CarDto(Builder builder) {
        this.carName = builder.carName;
        this.position = builder.position;
    }

    public String getCarName() {
        return this.carName;
    }

    public int getPosition() {
        return this.position;
    }
}
