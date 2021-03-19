package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private GameSet gameSet;
    private ResultView resultView;

    public RacingGame(GameSet gameSet) {
        this.gameSet = gameSet;
        resultView = new ResultView();
    }

    public List<RacingCar> settingRacingCars(String owners) {

        ArrayList<RacingCar> list = new ArrayList<>();
        String[] owner = owners.split(",");

        for (int i = 0; i < owner.length; i++) {
            RacingCar racingCar = new RacingCar(owner[i], new Position());
            list.add(racingCar);
        }

        return list;
    }

    public void gameStart(List<RacingCar> carList, int count) {
        numberingGameTimes(carList, count);
    }

    public void gameOver(List<RacingCar> carList) {
        Winner winner = new Winner();
        winner.showResult(winner.whoisWin(carList, gameSet));
    }


    private void numberingGameTimes(List<RacingCar> carList, int count) {
        for (int i = 0; i < count; i++) {
            numberingCars(carList);
            resultView.setResult("\n");
        }
        resultView.showResult();
        gameOver(carList);
    }


    private void numberingCars(List<RacingCar> carList) {
        for (int i = 0; i < carList.size(); i++) {
            carList.get(i).isGo(RandomNumber.random());
            resultView.setResult(carList.get(i).getOwner() + " : " + carList.get(i).status() + "\n");
        }
    }

}
