package study.race.io;

import java.util.List;

import study.race.Car;

public class RaceResultView {

    private String initMessage = "실행 결과";
    private StringBuilder result;

    public RaceResultView(List<Car> cars) {
        result = new StringBuilder();
        result.append(initMessage);
        setCarsHistory(cars);
    }

    private void setCarsHistory(List<Car> cars) {
        int triedNum = cars.get(0).getMoveHistory().size();
        for (int i = 0; i < triedNum; i++) {
            for (Car car : cars) {
                result.append(car.getMoveHistory().get(i) + "\n");
            }
            result.append("\n");
        }
    }
    
    public String getPrint() {
        return result.toString();
    }

}
