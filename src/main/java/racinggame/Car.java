package racinggame;

import java.util.Objects;

public class Car {

    private static final int MOVE_BOUND = 4;
    private int position;

    public Car(int position) {
        this.position = position;
    }

    public void move(int number) {
        if (MOVE_BOUND <= number) {
            position++;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return position == car.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    static class CarDto {

        private final int position;

        public CarDto(int position) {
            this.position = position;
        }

        public CarDto(Car car) {
            this(car.position);
        }

        public int position() {
            return position;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            CarDto carDto = (CarDto) o;
            return position == carDto.position;
        }

        @Override
        public int hashCode() {
            return Objects.hash(position);
        }
    }
}
