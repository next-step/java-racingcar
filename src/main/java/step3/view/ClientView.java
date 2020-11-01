package step3.view;

import step3.model.RandomCommander;
import step3.present.Presenter;

import java.util.Scanner;

public class ClientView {

    private static Presenter presenter = new Presenter(new RenderingView(), new RandomCommander());

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        int participantCar = scanner.nextInt();
        presenter.createParticipantRacingCar(participantCar);

        System.out.println("시도할 횟수는 몇 회 인가요?");
        int totalTry = scanner.nextInt();

        System.out.println("실행결과");
        for (int i = 0; i < totalTry; i++) {
            presenter.orderCommand(participantCar);
        }
    }

}
