package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private ResultView resultView;

    public RacingGame() {
        resultView = new ResultView();
    }

    public List<RacingCar> settingRacingCars(String owners) {

        ArrayList<RacingCar> carList = new ArrayList<>();
        String[] owner = owners.split(",");

        for (int i = 0; i < owner.length; i++) {
            RacingCar racingCar = new RacingCar(owner[i], new Location());
            carList.add(racingCar);
        }

        return carList;
    }

    public void gameStart(List<RacingCar> carList, int count) {
        numberingGameTimes(carList, count);
    }

    public void gameOver(List<RacingCar> carList) {
        Winner winner = new Winner();
        getWinners(winner.whoisWin(carList));
    }

    public String getWinners(List<RacingCar> winnerList) {

        String winner = "";

        if (winnerList.isEmpty()) {
            return winner;
        }

        for (int i = 0; i < winnerList.size(); i++) {
            winner += winnerList.get(i).getOwner() + ",";
        }

        winner = winner.replaceFirst(".$", "") + "가 최종 우승했습니다.";
        resultView.showWinner(winner);

        return winner;
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
            carList.get(i).canGo(RandomNumber.random());
            resultView.setResult(carList.get(i).getOwner() + " : " + carList.get(i).getCarLocation() + "\n");
        }
    }

}
