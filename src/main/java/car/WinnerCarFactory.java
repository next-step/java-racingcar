package car;

import java.util.ArrayList;
import java.util.List;

public class WinnerCarFactory implements CarFactory {
    public List<Car> generateCar(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            WinnerCar winnerCar = generateCar();
            winnerCar.inputName(carName);
            cars.add(winnerCar);
        }
        return cars;
    }

    @Override
    public WinnerCar generateCar() {
        return new WinnerCar(new CarMovableStrategy());
    }
}
