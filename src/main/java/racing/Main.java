package racing;

import racing.ui.InputView;

public class Main {

    public static void main(String[] args) {
        int numberOfParticipationCars = InputView.input("자동차는 몇 대 인가요?");
        int numberOfParticipationTry = InputView.input("시도 횟수는 몇 회 인가요?");

        System.out.println();
        System.out.println("실행결과");

        Racing.race(numberOfParticipationCars, numberOfParticipationTry);
    }
}
