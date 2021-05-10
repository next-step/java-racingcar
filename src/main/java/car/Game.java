package car;

import java.util.*;

public class Game {
    private Input input = new Input();
    private Output output = new Output();
    private Cut cut = new Cut();

    public void excute() {

        String carInput = input.carNameinput();

        String[] carInputs = carInput.split(",");

        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < carInputs.length; i++) {
            cars.add(cut.getCar(carInputs[i]));
        }

        if (cars.size() < 2) {
            return;
        }

        String count = input.countInput();

        output.carRacing(Integer.valueOf(count), cars);
    }
}
