package study;

import study.car.MemoryCarRepository;
import study.view.InputView;

public class RacingCarApplication {
    public static void main(String[] args) {
        MemoryCarRepository memoryCarRepository = new MemoryCarRepository();

        int setNumberOfCars = InputView.setNumberOfCars();
        int setNumberOfMoves = InputView.setNumberOfMoves();

        RacingCar racingCar = new RacingCar(setNumberOfCars, setNumberOfMoves, memoryCarRepository);
        racingCar.startRacing();
    }
}
