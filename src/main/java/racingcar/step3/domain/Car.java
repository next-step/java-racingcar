package racingcar.step3.domain;

import racingcar.step3.common.Consts;
import racingcar.step3.view.ResultView;

/**
 * Created : 2020-11-02 오전 8:32
 * Developer : Seo
 */
public class Car {
    private Record record;

    public Car() {
        this.record = new Record();
    }

    public void move(int random) {
        if (random > Consts.WHEN_THE_VALUE_IS_OVER_THREE) {
            record.setDistance();
        }
    }

    public int getDistance() {
        return record.getDistance();
    }

    public void record() {
        ResultView rv = new ResultView();
        rv.print(getDistance());
    }
}
