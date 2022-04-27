package study.step4.try1.view;

import study.step4.try1.domain.Car;
import study.step4.try1.domain.Winner;

import java.util.*;

public class ResultView {
    private List<Car> resultList;

    public ResultView(List<Car> resultList) {
        this.resultList = resultList;
    }

    public void printWinner() {
        String winners = Winner.findWinners(this.resultList);
        System.out.println(winners.trim().replaceAll(",$", "")+ "가 최종 우승했습니다.");
    }

    public void printRecordResult() {
        System.out.println("실행결과");

        for (int i = 0; i < this.resultList.size(); i++) {
            if (this.resultList.get(i) == null) {
                System.out.println();
                continue;
            }
            System.out.println(this.resultList.get(i).getName() + " : " + drawRoad(this.resultList.get(i)));
        }
    }

    private String drawRoad(Car car) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < car.maxPosition(); i++) {
            sb.append("-");
        }
        return sb.toString();
    }

}
