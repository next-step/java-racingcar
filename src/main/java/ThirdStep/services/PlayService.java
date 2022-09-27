package ThirdStep.services;

import ThirdStep.RandomMovingCondition;
import ThirdStep.model.GameSetting;

public class PlayService {

    public static final int ZERO = 0;
    public CarService carService;

    public PlayService(CarService carService) {
        this.carService = carService;
    }

    public void racing(GameSetting gameSetting) {
        if (gameSetting.getAttempts() == ZERO) {
            return;
        }

        gameSetting.getCars().forEach(car -> {
            carService.move(car, RandomMovingCondition.create());
            carService.printLocation(car);
        });

        System.out.println();
        gameSetting.reduceAttempts();
        this.racing(gameSetting);
    }

    public void announceWinner(GameSetting gameSetting) {
        carService.printWinner(gameSetting.getCars());
    }
}
