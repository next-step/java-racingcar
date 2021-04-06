package racingcar;

import racingcar.domain.RacingCar;
import racingcar.domain.Winner;
import racingcar.utils.RandomNumber;
import racingcar.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private ResultView resultView;
    private List<RacingCar> winnerList;
    protected int currentRound = 0;

    public RacingGame() {
        resultView = new ResultView();
        winnerList = new ArrayList<>();
    }

    public List<RacingCar> settingRacingCars(String owners) {

        ArrayList<RacingCar> carList = new ArrayList<>();
        String[] owner = owners.split(",");

        for (int i = 0; i < owner.length; i++) {
            RacingCar racingCar = new RacingCar(owner[i], 0);
            carList.add(racingCar);
        }

        return carList;
    }

    public boolean hasNextRound(int currentRound, int givenRound) {
        if (currentRound < givenRound) {
            return true;
        }
        return false;
    }

    public void getWinner(List<RacingCar> carList) {
        Winner winner = new Winner();
        resultView.showWinner(winner.findWinners(carList));
    }

    public void startRace(List<RacingCar> carList, int count) {
        while (hasNextRound(currentRound, count)) {
            showCarsStatus(carList);
            resultView.showRoundResult("\n");
            currentRound++;
        }
        resultView.showResult();
        getWinner(carList);
    }


    private void showCarsStatus(List<RacingCar> carList) {
        for (int i = 0; i < carList.size(); i++) {
            carList.get(i).move(RandomNumber.random());
            resultView.showCarStatus(carList.get(i).getOwner(), carList.get(i).getLocation());
        }
    }

}
