package car;

import java.util.*;

public class Game {
    private Input input = new Input();
    private Cut cut = new Cut();

    public void excute() {

        String carInput = input.carNameinput();

        String[] carInputs = carInput.split(",");

        List<Car> cars = new ArrayList<>();

        for (String carName : carInputs) {
            cars.add(cut.getCar(carName));
        }

        if (cars.size() < 2) {
            return;
        }

        String count = input.countInput();

        Output output = new Output(cars);

        output.carRacing(Integer.valueOf(count));
    }
}
