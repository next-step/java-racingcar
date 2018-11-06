package racing;

import racing.msg.Question;
import racing.rule.Forward;
import racing.view.Input;
import racing.view.Result;

public abstract class Main {

    private Main() {
    }

    public static void main(final String[] args) {

        final String names = Input.StringQuestion(Question.FIRST);
        final int tryCount = Input.IntegerQuestion(Question.SECOND);

        final Game racing = new Racing(names, tryCount, new Forward());

        while (racing.hasTryCount()) {
            racing.start();
            Result.positionPrint(racing.getCars());
        }

        Result.printWinner(racing.getCars());

    }

}
