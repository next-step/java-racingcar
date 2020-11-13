package study.step4;

/*
 * Race
 *
 * 1.0.0
 *
 * 2020-11-13
 */
public class Race {
    static int raceCount;

    /* 시작 */
    static public void start() {
        for (int i = 0; i < raceCount; i++) {
            loopByCarCount();
        }
        ResultView.printCrlf();
    }

    /* 자동차 수만큼 시도 로직 반복 */
    static private void loopByCarCount() {
        for (int i = 0; i < Cars.cars.size(); i++) {
            ResultView.printMessage(Cars.cars.get(i).name + " : ");
            loopByRaceCount(Cars.cars.get(i));
        }
        ResultView.printCrlf();
    }

    /* 시도 회수만큼 전진 로직 반복 */
    static private void loopByRaceCount(Car car) {
        for (int i = 0; i < raceCount; i++) {
            car.go(car.randomNumber());
        }
        ResultView.printCrlf();
    }

    /* 임시 테스트 */
    public static void main(String[] args) {
        // 자동차 세팅
        String carNames = InputView.inputCars();
        Cars cars = new Cars();
        cars.split(carNames);
        // 기회 세팅
        raceCount = InputView.inputRacingCount();
        // 경주 시작
        Race.start();
        // 우승자
        Cars.winner();
        // 우승자 출력
        ResultView.printWinner();
    }
}