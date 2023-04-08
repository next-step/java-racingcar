package step3.view;

import step3.domain.Repetitions;

public class PrintView {

    private final static String MOVE_PRINT_STRING = "-";

    private PrintView() {
    }

    private static class PrintViewInstanceHolder {
        private static final PrintView INSTANCE = new PrintView();
    }

    private PrintView getInstance() {
        return PrintViewInstanceHolder.INSTANCE;
    }

    public void print(Repetitions repetitions) {
        System.out.println(repetitions.getRepetitions() + "번째 reps");
        repetitions.getCarList().forEach(car -> printRacingCar(car.getPosition().getPosition()));
    }

    public void printRacingCar(int position) {

        for (int index = 0; index < position; index++) {
            System.out.print(MOVE_PRINT_STRING);
        }
        System.out.println();
    }
}
