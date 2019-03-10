package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import org.apache.commons.lang3.StringUtils;

public class RacingGame {

    static class RacingGameHelper {

        static private int numberOfCars;
        static private int numberOfTimes;

        private static void configure() {
            Scanner scanner = new Scanner(System.in);

            System.out.println("자동차 대수는 몇 대 인가요? ");
            numberOfCars = scanner.nextInt();

            System.out.println("시도할 회수는 몇 회 인가요? ");
            numberOfTimes = scanner.nextInt();
        }

        static void show(List<RacingGameBoard> racingGameBoards) {
            for (int i = 0; i < numberOfTimes; i++) {
                for (int j = 0; j < numberOfCars; j++) {
                    System.out.println(StringUtils.repeat("-", racingGameBoards.get(i).getCars().get(j).getPosition()));
                }

                System.out.println();
            }
        }
    }

    static List<RacingGameBoard> load(int numberOfCars, int numberOfTimes) throws Exception {

        if (numberOfCars == 0 || numberOfTimes == 0) {
            throw new Exception("게임 로딩 실패...");
        }

        List<RacingGameBoard> racingGameBoards = new ArrayList<>();

        for (int i = 0; i < numberOfTimes; i++) {
            racingGameBoards.add(new RacingGameBoard(i, numberOfCars));
        }

        return racingGameBoards;
    }

    static List<RacingGameBoard> play(List<RacingGameBoard> racingGameBoards, int numberOfCars, int numberOfTimes) throws Exception {
        if (Objects.isNull(racingGameBoards)) {
            throw new Exception("게임 시작 실패...");
        }

        for (int i = 0; i < numberOfTimes; i++) {
            racingGameBoards.get(i).play();

            for (int j = 0; j < numberOfCars; j++) {
                int prevPosition = i - 1 < 0 ? 0 : racingGameBoards.get(i - 1).getCars().get(j).getPosition();
                int curPosition = prevPosition + racingGameBoards.get(i).getCars().get(j).getMove();

                racingGameBoards.get(i).getCars().get(j).setPosition(curPosition);
            }
        }

        return racingGameBoards;
    }

    public static void main(String[] args) throws Exception {

        RacingGameHelper.configure();

        List<RacingGameBoard> racingGameBoards = load(RacingGameHelper.numberOfCars, RacingGameHelper.numberOfTimes);
        play(racingGameBoards, RacingGameHelper.numberOfCars, RacingGameHelper.numberOfTimes);

        RacingGameHelper.show(racingGameBoards);

        System.out.println(racingGameBoards);
    }


}
