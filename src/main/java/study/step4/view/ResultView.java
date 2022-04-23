package study.step4.view;

import study.step4.domain.Car;

import java.util.*;

public class ResultView {
    private List<Car> resultList;

    public ResultView(List<Car> resultList) {
        this.resultList = resultList;
    }

    public void printWinner() {
        Map<String, Integer> map = new HashMap<>();
        for (Car car : resultList) {
            if (car == null) continue;
            map.put(car.getName(), car.maxPosition());
        }
        StringBuilder sb = new StringBuilder();
        Map.Entry<String, Integer> maxEntry = null;
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        int idx = 0;
        for (Map.Entry<String, Integer> entry : entrySet) {
            if (idx == 0) {
                maxEntry = entry;
                idx++;
            }
            if (entry.getValue() > maxEntry.getValue()) {
                sb.setLength(0);
                sb.append(entry.getKey()+", ");
                maxEntry = entry;
                continue;
            }
            if (entry.getValue() == maxEntry.getValue()) {
                sb.append(entry.getKey()+", ");
            }
        }
        System.out.println(sb.toString().trim().replaceAll(",$", "")+ "가 최종 우승했습니다.");
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
