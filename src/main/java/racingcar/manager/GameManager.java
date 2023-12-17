package racingcar.manager;

import racingcar.model.Car;
import racingcar.ui.UIInGame;
import racingcar.util.RandomNumberGenerator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameManager {
    private UIManager uiManager = new UIManager();

    public void startGame(){
        introScene();
    }

    private void introScene() {
        int inputNum = uiManager.showIntro();
        if (inputNum == 1){
            inGame(uiManager.showStartInGame());
        }
        if (inputNum == 2){
            System.exit(0);
        }
    }

    private void inGame(List<Integer> inputList) {
        Integer carCount = inputList.get(0);
        Map<Integer, Car> carList = new HashMap<>(carCount);
        Integer roundCount = inputList.get(1);
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        for (int carNum = 1; carNum <= carCount; carNum++) {
            Car car = new Car(carNum, 0);
            carList.put(carNum, car);
        }
        for (int round = 1; round <= roundCount; round++) {
            for (int carNum = 1; carNum <= carCount; carNum++) {
                if (randomNumberGenerator.generate() >= 4){
                    carList.get(carNum).move();
                }
            }
            UIInGame.printPosition(round, carList);
        }
    }

}
