package racingcargame;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Racing {
    List<Car> cars;  //자동차리스트
    int tryCnt; //시도횟수

    void race(List<Car> cars) {
        for (int i = 0; i < cars.size(); i++) {
            double dValue = Math.random();
            int iValue = (int) (dValue * 10);
            if (iValue >= 4) cars.get(i).addScore(); //4 이상인 경우에만 스코어 증가
        }
    }

    void print(List<Car> carList) {
        for (int i = 0; i < carList.size(); i++) {
            System.out.println(carList.get(i).getName() + " : " + getScore(carList.get(i)));
        }
        System.out.println("");
    }

    String getScore(Car car) {
        String score = "";
        for (int i = 0; i < car.getScore(); i++) {
            score += "-";
        }
        return score;
    }

    String getWinner(List<Car> carList) {
        int winnerScore = 0;
        int winnerPosition = 0;
        for (int i = 0; i < carList.size(); i++) {
            if (winnerScore < carList.get(i).getScore()) {
                winnerScore = carList.get(i).getScore();
                winnerPosition = i;
            }
        }
        String winner = "";
        //winnerScore와 같은 이름을 찾는다
        for (int i = 0; i < carList.size(); i++) {
            if (winnerScore == carList.get(i).getScore()) {
                if (!"".equals(winner)) winner += ", ";
                winner += carList.get(i).getName();
            }
        }

        return winner;
    }
}