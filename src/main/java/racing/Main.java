package racing;

import racing.msg.Question;
import racing.rule.Forward;
import racing.utils.StringUtils;
import racing.view.Input;
import racing.view.Result;

import java.util.Arrays;

import static java.util.stream.Collectors.toList;

public abstract class Main {

    private Main() {
    }

    public static void main(final String[] args) {

        final String inputCarRacers = Input.StringQuestion(Question.FIRST);
        final int inputTryCount = Input.IntegerQuestion(Question.SECOND);

        final Game racing = new Racing(
                Arrays.stream(StringUtils.split(inputCarRacers, ","))
                        .map(carRacer -> new Car(new CarRacer(carRacer), new Forward()))
                        .collect(toList())
                , inputTryCount
        );

        while (racing.hasTryCount()) {
            racing.start();
            Result.positionPrint(racing.getList());
        }

        Result.printWinner(racing.getList());

    }

}
