package study;

import study.car.Car;
import study.car.CarServiceImpl;
import study.car.MemoryCarRepository;
import study.racing.RacingCarPolicy;
import study.utils.RandomUtils;
import study.view.ResultView;

import java.util.List;

public class RacingCar {

    private int numberOfCar;
    private int numberOfMoves;
    private CarServiceImpl carService;

    public RacingCar(int numberOfCar, int numberOfMoves, MemoryCarRepository memoryCarRepository) {
        this.numberOfCar = numberOfCar;
        this.numberOfMoves = numberOfMoves;
        this.carService = new CarServiceImpl(memoryCarRepository);
    }

    public void startRacing() {
        setCarList();
        ResultView.beforeRacingPrintMessage();

        List<Car> Cars = carService.findAllCars();
        for (int i = 0; i < numberOfMoves; i++) {
            moveOrStopCar(Cars);
            ResultView.printOneRacingResult(Cars);
        }
    }

    private void setCarList() {
        for (int i = 0; i < numberOfCar; i++) {
            Car car = new Car();
            carService.join(car);
        }
    }

    private void moveOrStopCar(List<Car> Cars) {
        for (Car car : Cars) {
            if (RacingCarPolicy.canMovingCar(RandomUtils.getRandomNumberZeroToNine())) {
                carService.movingCar(car);
            }
        }
    }
}
