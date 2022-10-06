package carracing.view;

import carracing.model.MoveResult;

public class ConsoleGameDashBoard implements OutputInterface {
    private static final String STRAIGHT_MARK = "-";

    @Override
    public void showCurrentStatus(MoveResult moveResult) {
        for (int count = 0; count < moveResult.getStraightCount(); count++) {
            System.out.print(STRAIGHT_MARK);
        }
        System.out.println("");
    }
}
