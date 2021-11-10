package racingcar.view;

import racingcar.Racing;
import racingcar.RandomMovePredicate;

public class Client {
    public static void main(String[] args) {
        InputView iv = new InputView();
        ResultView rv = new ResultView();

        iv.take();

        Racing racing = new Racing(iv.round(), iv.carNames());
        racing.start(new RandomMovePredicate());

        rv.show(racing.record(), racing.winners());
    }
}
