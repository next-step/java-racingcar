package racing.view;

import racing.domain.Car;
import racing.message.ViewMsg;

public class ResultView {
    public void viewResultMsg() {
        System.out.println(ViewMsg.RESULT_VIEW_START.getMsg());
    }

    public String getLocationVisualization(int location) {
        String result = "";
        for (int i=0; i<location; i++) {
            result += "-";
        }
        return result;
    }

    public void viewGameStatus(Car car) {
            System.out.println(car.getName() + " : " + this.getLocationVisualization(car.getLocation()));
    }

    public void printVictory(String names) {
        System.out.println(names + ViewMsg.VICTORY_MSG.getMsg());
    }

}
