package racing.fake;

import racing.domain.Car;

public class FakeCar extends Car {
    private int position;

    public FakeCar(String name, int position) {
        super(name);
        this.position = position;
    }

    @Override
    public int findCurrentPosition() {
        return this.position;
    }
}
