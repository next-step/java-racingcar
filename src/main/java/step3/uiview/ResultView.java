package step3.uiview;

import step3.car.CarStrategy;
import step3.message.Message;

import java.util.List;

public class ResultView {

    private final static String DISTANCE_DISPLAY = "-";

    //현재 레이싱결과를 출력한다.
    public void resultView(List<List<CarStrategy>> raceSituation) {
        System.out.println(Message.RESULT_MESSAGE.message());
        raceSituationResultView(raceSituation);
    }

    private void raceSituationResultView(List<List<CarStrategy>> raceSituation) {
        for (List<CarStrategy> carStrategy : raceSituation) {
            carSituationResultView(carStrategy);
            System.out.println();
        }
    }

    private void carSituationResultView(List<CarStrategy> carStrategies) {
        for (CarStrategy carStrategy : carStrategies) {
            System.out.println(DISTANCE_DISPLAY.repeat(carStrategy.getDistance()));
        }
    }
}
