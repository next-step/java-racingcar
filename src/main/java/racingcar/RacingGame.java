package racingcar;

import racingcar.domain.Location;
import racingcar.domain.Owner;
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
            RacingCar racingCar = new RacingCar(new Owner(owner[i]), new Location(0));
            carList.add(racingCar);
        }

        return carList;
    }

    public void gameStart(List<RacingCar> carList, int count) {
        numberingGameTimes(carList, count);
    }

    public void gameOver(List<RacingCar> carList) {
        Winner winner = new Winner();
        resultView.showResult();
    }

    private void numberingGameTimes(List<RacingCar> carList, int count) {
        for (int i = 0; i < count; i++) {
            numberingCars(carList);
            resultView.showRoundResult("\n");
        }
        resultView.showResult();
        gameOver(carList);
    }


    private void numberingCars(List<RacingCar> carList) {
        for (int i = 0; i < carList.size(); i++) {
            carList.get(i).move(RandomNumber.random());
            resultView.showCarStatus(carList.get(i).getOwner(), carList.get(i).getLocation());
        }
    }

}
