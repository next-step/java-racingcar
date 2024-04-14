import java.util.List;

public class Cars {
    private final List<Car> value;

    public Cars(List<Car> value) {
        this.value = value;
    }

    public List<Car> getValue() {
        return this.value;
    }

    public void move() {
        for (Car car : this.value) {
            car.move();
        }
    }
}
