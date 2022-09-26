package ThirdStep;

import ThirdStep.model.GameSetting;

public class Play {

    public static final int ZERO = 0;
    public CarAction carAction;

    public Play(CarAction carAction) {
        this.carAction = carAction;
    }

    public void racing(GameSetting gameSetting) {
        if (gameSetting.getAttempts() == ZERO) {
            return;
        }

        gameSetting.getCars().forEach(car -> {
            carAction.move(car, RandomMovingCondition.create());
            carAction.printLocation(car);
        });

        System.out.println();
        gameSetting.setAttempts(gameSetting.getAttempts() - 1);
        this.racing(gameSetting);
    }

    public void announceWinner(GameSetting gameSetting) {
        carAction.printWinner(gameSetting.getCars());
    }
}
