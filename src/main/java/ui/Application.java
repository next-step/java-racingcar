package ui;

import car_racing.Car;
import car_racing.CarRacing;
import dto.InputDto;
import util.RandomNumberGenerator;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputDto inputDto;
        try {
            inputDto = InputView.getInputDto();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
        CarRacing carRacing = new CarRacing(Car.generateCars(inputDto.getCarNames(), new RandomNumberGenerator()));
        run(carRacing, inputDto.getTrySize());
        List<Car> winCars = carRacing.getWinner();
        ResultView.printWinCar(winCars);

    }

    private static void run(CarRacing carRacing, int trySize) {
        for (int i = 0; i < trySize; i++) {
            carRacing.moveCars();
            ResultView.printMovingOfCars(carRacing.getCars());
            System.out.println();
        }
    }
}
