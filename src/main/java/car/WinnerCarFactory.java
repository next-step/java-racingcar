package car;

public class WinnerCarFactory implements CarFactory {
    @Override
    public Car generateCar() {
        return new WinnerCar(new CarMovableStrategy());
    }
}
