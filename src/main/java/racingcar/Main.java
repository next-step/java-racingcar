package racingcar;

public class Main {
    public static void main(String[] args) {
        // TODO 자동차 개수, 횟수 입력받기
        int carCount = 3;
        int raceCount = 5;

        Race race = new Race(carCount, raceCount);
        race.startRace();
    }
}
