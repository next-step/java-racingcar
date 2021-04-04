package racingcar;

import racingcar.command.NumberType;
import racingcar.domain.RacingCar;
import racingcar.domain.Winner;
import racingcar.utils.RandomNumber;
import racingcar.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private ResultView resultView;
    private List<RacingCar> winnerList;

    public RacingGame() {
        resultView = new ResultView();
        winnerList = new ArrayList<>();
    }

    public List<RacingCar> settingRacingCars(String owners) {

        ArrayList<RacingCar> carList = new ArrayList<>();
        String[] owner = owners.split(",");

        for (int i = 0; i < owner.length; i++) {
            RacingCar racingCar = new RacingCar(owner[i], NumberType.ZERO.value());
            carList.add(racingCar);
        }

        return carList;
    }

    public void gameStart(List<RacingCar> carList, int count) {
        showGameTimes(carList, count);
    }

    public void gameOver(List<RacingCar> carList) {
        Winner winner = new Winner();
        resultView.showWinner(winner.findWinners(carList));
    }


    private void showGameTimes(List<RacingCar> carList, int count) {
        for (int i = 0; i < count; i++) {
            showCarsStatus(carList);
            resultView.showRoundResult("\n");
        }
        resultView.showResult();
        gameOver(carList);
    }


    private void showCarsStatus(List<RacingCar> carList) {
        for (int i = 0; i < carList.size(); i++) {
            carList.get(i).move(RandomNumber.random());
            resultView.showCarStatus(carList.get(i).getOwner(), carList.get(i).getLocation());
        }
    }

}
