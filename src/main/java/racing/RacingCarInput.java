package racing;

import java.util.Scanner;

public class RacingCarInput {
    public void requestInput() throws IllegalArgumentException{
        Scanner sc = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        validInputCheck_NumOfCar(sc.nextInt());
        System.out.println("시도할 회수는 몇 회 인가요?");
        validInputCheck_CycleOfRacing(sc.nextInt());
    }

    public void validInputCheck_NumOfCar(int cnt) {
        final String errorMessage = "자동차의 수가 너무 적거나 많습니다. (range: 1~5)";
        final int threthold = 5;
        if (0 >= cnt || threthold < cnt ) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public void validInputCheck_CycleOfRacing(int cnt) {
        final String errorMessage = "시도할 회수가 너무 적거나 많습니다. (range: 1~10)";
        final int threthold = 10;
        if (0 >= cnt || threthold < cnt ) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
