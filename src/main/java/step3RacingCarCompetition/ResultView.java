package step3RacingCarCompetition;

import java.util.stream.IntStream;

public class ResultView {

    /**
     * 현재 시도회수까지 출력하는 메서드
     */
    public static void printCurrentCarMovement(RacingCarInfo racingCarInfo, int totalNumberOfCars) {
        IntStream.range(0, totalNumberOfCars)
                .mapToObj(racingCarInfo::findRacingCarData)
                .forEachOrdered(System.out::println);
        System.out.println();
    }
}
