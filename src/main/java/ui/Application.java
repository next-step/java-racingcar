package ui;

import car_racing.Car;
import car_racing.CarRacing;
import dto.InputDto;
import util.RandomNumberGenerator;

public class Application {
    public static void main(String[] args) {
        InputDto inputDto = InputView.getInputDto();
        CarRacing carRacing = new CarRacing(Car.generateCars(inputDto.carSize, new RandomNumberGenerator()));
        run(carRacing, inputDto.trySize);
    }

    private static void run(CarRacing carRacing, int trySize) {
        for (int i = 0; i < trySize; i++) {
            carRacing.moveCars();
            ResultView.printMovingOfCars(carRacing.getCars());
            System.out.println();
        }
    }
}
