package racingcar.step3.view;

import racingcar.step3.common.Consts;
import racingcar.step3.domain.Cars;

import java.util.Map;

/**
 * Created : 2020-11-02 오전 8:25.
 * Developer : Seo.
 */
public class ResultView {

    public void print(Cars cars) {
        title();
        grid(cars);
        winner(cars);
    }

    private void title() {
        System.out.println(Consts.RESULT);
    }

    private void grid(Cars cars) {
        cars.getTotalRecords().forEach(t -> System.out.println(distance(t)));
    }

    private String distance(Map<String, Integer> turnRecords) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : turnRecords.entrySet()) {
            sb.append(entry.getKey()).append(Consts.COLON);
            for (int i = 0; i < entry.getValue(); i++) {
                sb.append("-");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private void winner(Cars cars) {
        System.out.println(cars.getWinner() + Consts.HAVE_BEEN_A_WINNER);
    }

}
