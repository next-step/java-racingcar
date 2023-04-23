package carracing.present;

import carracing.model.Presenter;

import static java.lang.System.lineSeparator;

public class OutputPresent {
    public void printResult(Presenter presenter) {
        for (int i = 0; i < presenter.iterationCount(); i++) {
            System.out.print(lineSeparator());
            for (int j = 0; j < presenter.participateCount(); j++) {
                System.out.printf("%s : %s %s", presenter.participateName(j), presenter.resultQuery(i, j), lineSeparator());
            }
        }
    }

    public void printWinner(Presenter presenter) {
        System.out.printf("우승자는 %s 입니다", presenter.totalParticipateNames());
    }
}
