package racingcar;

import java.util.ArrayList;
import java.util.List;

public class ResultView {

    private static final String RESULT_DASH = "-";

    private List<String> winners = new ArrayList<>();

    /**
     * 현재 결과를 출력합니다
     */
    public void printResult(RacingCarDriver racingCarController) {
        for (int distance : racingCarController.getNowDistance()) {
            this.printDash(distance);
        }
    }

    /**
     * 주어진 거리만큼 '-'를 출력합니다.
     * @param distance
     */
    private void printDash(int distance) {
        for (int i = 0; i < distance; i++) {
            System.out.print(ResultView.RESULT_DASH);
        }
        System.out.println();
    }

    /**
     * 경주가 시작되어 실행결과를 보여 줄 때 출력합니다.
     */
    public void printStartResult() {
        System.out.println("실행 결과");
    }

    /**
     * 하나의 라운드가 종료 될 때 한줄을 띄워줍니다.
     */
    public void printEndRound() {
        System.out.println();
    }

    /**
     * 현재 결과를 출력합니다
     */
    public void printResultWithName(NamedRacingCarDriver namedRacingCarDriver) {
        for (RacingCar racingCar : namedRacingCarDriver.getRacingCars()) {
            NamedRacingCar namedRacingCar = (NamedRacingCar) racingCar;
            System.out.print(namedRacingCar.getName() + " : ");
            this.printDash(namedRacingCar.getDistance());
        }
    }

    /**
     * 우승자를 출력합니다.
     * @param namedRacingCarDriver
     */
    public void printWinner(NamedRacingCarDriver namedRacingCarDriver) {
        List<String> winners = this.getWinner(namedRacingCarDriver);
        for (int i = 0; i < winners.size(); i++) {
            this.printDelimiter(i);
            System.out.print(winners.get(i));
        }
        System.out.println("가 최종 우승했습니다.");
    }

    /**
     * 우승자가 여러명일 경우, 우승자 이름 사이에 구분자를 출력합니다
     * @param i
     */
    private void printDelimiter(int i) {
        if(i > 0) {
            System.out.print(" , ");
        }
    }

    /**
     * 우승자가 누구인지 가져옵니다.
     * @param namedRacingCarDriver
     * @return
     */
    private List<String> getWinner(NamedRacingCarDriver namedRacingCarDriver) {
        int longestDistance = 0;
        for (RacingCar racingCar : namedRacingCarDriver.getRacingCars()) {
            NamedRacingCar namedRacingCar = (NamedRacingCar) racingCar;

            int distance = namedRacingCar.getDistance();

            longestDistance = this.validateLongestDistance(longestDistance, distance);

            this.addLongestDistance(longestDistance, distance, namedRacingCar.getName());

        }
        return this.winners;
    }

    /**
     * 주어진 거리가 가장 긴 거리이면 새로운 우승자 명단을 만들고 가장 긴 거리를 변경합니다.
     * @param longestDistance
     * @param distance
     * @return longestDistance
     */
    private int validateLongestDistance(int longestDistance, int distance) {
        if(distance > longestDistance) {
            this.winners = new ArrayList<>();
            longestDistance = distance;
        }
        return longestDistance;
    }

    /**
     * 주어진 거리가 가장 긴 거리이면 우승자 명단에 이름을 추가합니다.
     * @param longestDistance
     * @param distance
     * @param name
     */
    private void addLongestDistance(int longestDistance, int distance, String name) {
        if(distance >= longestDistance) {
            this.winners.add(name);
        }
    }
}
