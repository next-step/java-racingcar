package racing;

import racing.msg.Question;
import racing.rule.Forward;
import racing.view.Input;
import racing.view.Result;

public abstract class Main {

    private Main() {
    }

    public static void main(final String[] args) {

        final String carRacers = Input.StringQuestion(Question.FIRST);
        final int tryCount = Input.IntegerQuestion(Question.SECOND);

        final Game racing = new Racing(carRacers, tryCount, new Forward());
        while (racing.hasTryCount()) {
            racing.start();
            Result.positionPrint(racing.getList());
        }

        Result.printWinner(racing.getList());

    }

}
