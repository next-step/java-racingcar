package study.step4;

import java.util.Random;

/*
 * Race
 *
 * 1.0.0
 *
 * 2020-11-13
 */
public class Race {
    private static int raceCount;
    private static Random random = new Random();
    /* 시작 */
    public static void start(Cars cars) {
        for (int i = 0; i < raceCount; i++) {
            loopByCarCount(cars);
        }
        ResultView.printCrlf();
    }

    /* 자동차 수만큼 시도 로직 반복 */
    private static void loopByCarCount(Cars cars) {
        for (int i = 0; i < cars.getSize(); i++) {
            ResultView.printMessage(cars.getIndexName(i) + " : ");
            loopByRaceCount(cars.getIndex(i));
        }
        ResultView.printCrlf();
    }

    /* 시도 회수만큼 전진 로직 반복 및 스코어 초기화 */
    private static void loopByRaceCount(Car car) {
        for (int i = 0; i < raceCount; i++) {
            car.go(randomNumber());
        }
        ResultView.printScore(car);
        ResultView.printCrlf();
        car.initScore();
    }

    /* 1~10 사이 랜덤숫자 추출 */
    public static int randomNumber () {
        return random.nextInt(10);
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
        Race.start(cars);
        // 우승자
        cars.winner();
        // 우승자 출력
        ResultView.printWinner(cars);
    }
}