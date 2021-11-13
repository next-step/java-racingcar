package step3;

import step3.movingstrategy.RandomMovingStrategy;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SimpleCarRacingGame {
    public static void main(String[] args) {
        System.out.println("초간단 자동차 게임을 시작합니다!");

        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대인가요?");
        int participantsNumber = scanner.nextInt();

        System.out.println("시도할 회수는 몇 회인가요?");
        int roundNumbers = scanner.nextInt();

        LocationReporter reporter = new LocationReporter();
        List<Car> participants = Stream.generate(Car::new).limit(participantsNumber).collect(Collectors.toList());

        Contest contest = new Contest(roundNumbers, participants, new RandomMovingStrategy(), reporter);
        contest.play();
    }
}
