import java.util.List;

public class ResultViewWithWinner {
    public static void main(String... args) {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String racingCars = InputView.inputString();

        String[] racingCarNames = racingCars.split(",");
        RacingCars cars = new RacingCars(racingCarNames);

        System.out.println("시도할 회수는 몇 회 인가요?");
        int races = InputView.inputInteger();

        System.out.println("실행 결과");
        raceResult(cars, races);

        RacingCarService racingCarService = new RacingCarService();
        System.out.println(racingCarService.findRaceWinners(cars) + "가 최종 우승했습니다.");
    }

    private static void raceResult(RacingCars racingCars, int races) {
        for (int count = 1; count <= races; count++) {
            racingCars.move();
            outputCarsLocation(racingCars);
        }
    }

    private static void outputCarsLocation(RacingCars racingCars) {
        List<Integer> distances = racingCars.distance();
        List<String> names = racingCars.name();

        for (int index = 0; index < names.size(); index++) {
            System.out.println(names.get(index) + " : " + createCarDistanceBar(distances.get(index)));
        }
        System.out.println();
    }

    private static String createCarDistanceBar(int distance) {
        StringBuilder stringBuilder = new StringBuilder();

        while (distance > 0) {
            stringBuilder.append("-");
            distance--;
        }

        return stringBuilder.toString();
    }
}
