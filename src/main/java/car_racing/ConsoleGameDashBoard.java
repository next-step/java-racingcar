package car_racing;

public class ConsoleGameDashBoard implements OutputInterface {
    private static final String STRAIGHT_MARK = "-";

    @Override
    public void showCurrentStatus(int straightCount) {
        for (int count = 0; count < straightCount; count++) {
            System.out.print(STRAIGHT_MARK);
        }
        System.out.println("");
    }
}
