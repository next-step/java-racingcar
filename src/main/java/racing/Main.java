package racing;

import racing.msg.Question;
import racing.rule.Forward;
import racing.view.Input;
import racing.view.Result;

public abstract class Main {

    private Main() {
    }

    public static void main(final String[] args) {

        final int carCount = Input.question(Question.FIRST);
        final int tryCount = Input.question(Question.SECOND);

        final Game racing = new Racing(carCount, tryCount, new Forward());
        while (racing.hasTryCount()) {
            racing.start();
            Result.positionPrint(racing.getList());
        }

    }

}
