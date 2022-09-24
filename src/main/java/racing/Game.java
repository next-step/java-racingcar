package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    private List<Racer> racers = new ArrayList<>();
    private Umpire umpire = new Umpire();

    public void play() {
        Scanner sc = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        final int racerCount = sc.nextInt();
        System.out.println(racerCount);

        this.racerSetting(racerCount);

        System.out.println("시도할 회수는 몇 회 인가요?");
        final int roundCount = sc.nextInt();
        this.playRace(roundCount);

    }

    private void playRace(int roundCount) {
        for (int i = 0; i < roundCount; i++) {
            this.playRound();
        }
    }

    private void playRound() {
        for (Racer racer : racers) {
            this.isGoStraight(racer);
            racer.printRacerAndCurrentLocation();
        }
        System.out.println("라운드 종료");
    }

    private void isGoStraight(Racer racer) {
        umpire.resetAdvanceCondition();
        if (umpire.isGoStraight()) {
            racer.goStraight();
        }
    }

    private void racerSetting(int racerCount) {
        for (int i = 1; i <= racerCount; i++) {
            Racer racer = new Racer(i);
            racers.add(racer);
        }

    }
}
