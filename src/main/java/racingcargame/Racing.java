package racingcargame;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Racing {
    List<Car> carList;  //자동차리스트
    int tryCnt; //시도횟수

    void race(List<Car> carList){
        for(int i=0; i<carList.size(); i++){
            double dValue = Math.random();
            int iValue = (int)(dValue * 10);
            if(iValue >= 4) carList.get(i).score++; //4 이상인 경우에만 스코어 증가
        }
    }

    void print(List<Car> carList){
        for(int i=0; i<carList.size(); i++){
            System.out.println(carList.get(i).name + " : " + getScore(carList.get(i)));
        }
        System.out.println("");
    }

    String getScore(Car car){
        String score = "";
        for(int i=0; i<car.score; i++){
            score += "-";
        }
        return score;
    }

    String getWinner(List<Car> carList){
        int winnerScore = 0;
        int winnerPosition = 0;
        for(int i=0; i<carList.size(); i++) {
            if(winnerScore < carList.get(i).score){
                winnerScore = carList.get(i).score;
                winnerPosition = i;
            }
        }
        String winner = "";
        //winnerScore와 같은 이름을 찾는다
        for(int i=0; i<carList.size(); i++) {
            if(winnerScore == carList.get(i).score){
                if(!"".equals(winner)) winner += ", ";
                winner += carList.get(i).name;
            }
        }

        return winner;
    }
}