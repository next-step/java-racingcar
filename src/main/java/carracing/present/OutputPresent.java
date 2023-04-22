package carracing.present;

import carracing.model.Presenter;

public class OutputPresent {
    public void printResult(Presenter presenter) {
        for (int i = 0; i< presenter.iterationCount() ; i++) {

            for (int j = 0; j< presenter.participateCount() ; j++ ) {
                String s = presenter.getRecord(i, j);
                System.out.print(presenter.participateName(j));
                System.out.println(s);
            }
        }
    }

    public void printWinner(Presenter presenter) {
        System.out.printf("우승자는 %s 입니다", presenter.totalParticipateNames());
    }


}
