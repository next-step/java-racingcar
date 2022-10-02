
import domain.Car;

public abstract class TestSupport {
    protected static final int INIT_LOCATION = 0;

    protected static String[] testCarNames = {"test1", "test2", "test3"};

    protected static Car testCar1() {
        return new Car("test1");
    }

    protected static Car testCar2() {
        return new Car("test2");
    }

    protected static Car testCar3() {
        return new Car("test3");
    }

}
