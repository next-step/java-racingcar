package racingcar.step3.view;

import racingcar.step3.common.Consts;
import racingcar.step3.domain.Car;
import racingcar.step3.domain.Record;

/**
 * Created : 2020-11-02 오전 8:25.
 * Developer : Seo.
 */
public class ResultView {

    public void printResult(Car car) {
        System.out.println(gridDistance(car));
    }

    private String gridDistance(Car car) {
        StringBuilder sb = new StringBuilder();
        sb.append(car.getName()).append(" : ");
        for (int i = 0; i < car.getDistance(); i++) {
            sb.append("-");
        }
        return sb.toString();
    }

    public void printTurnOver() {
        System.out.println();
    }

    public void printResultTitle() {
        System.out.println(Consts.RESULT);
    }

    public void printWinner(Record record) {
        System.out.println(record.getWinner() + Consts.HAVE_BEEN_A_WINNER);
    }
}
