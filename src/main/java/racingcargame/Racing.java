package racingcargame;

import java.util.List;

public class Racing {
    private List<Car> cars;  //자동차리스트
    private int tryCount; //시도횟수

    public Racing(List<Car> cars, int tryCount) {
        this.cars = cars;
        this.tryCount = tryCount;
    }

    public void race() {
        for (int i = 0; i < cars.size(); i++) {
            double randomValue = Math.random();
            int iValue = (int) (randomValue * 10);
            if (iValue >= 4) cars.get(i).addScore(); //4 이상인 경우에만 스코어 증가
            ResultView resultView = new ResultView();
            resultView.printRace(cars.get(i));
        }
        System.out.println("");
    }

    public String getWinner() {
        int winnerScore = 0;
        int winnerPosition = 0;
        for (int i = 0; i < cars.size(); i++) {
            if (winnerScore < cars.get(i).getScore()) {
                winnerScore = cars.get(i).getScore();
                winnerPosition = i;
            }
        }
        String winner = "";
        for (Car car : cars) {
            if (winnerScore == car.getScore()) {
                if (!"".equals(winner)) winner += ", ";
                winner += car.getName();
            }
        }
        return winner;
    }

    public int getTryCount() {
        return tryCount;
    }
}