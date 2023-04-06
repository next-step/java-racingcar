package step3.view;

import step3.domain.Repetitions;

public class PrintView {

    private final static String MOVE_PRINT_STRING = "-";

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
