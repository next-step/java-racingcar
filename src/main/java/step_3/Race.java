package step_3;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Race {

    public static void main(String[] args) {
        Race race = new Race();
        race.start();
    }

    private void start() {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("자동차 대수는 몇 대 인가요?");
            int carCount = sc.nextInt();

            System.out.println("시도할 회수는 몇 회 인가요?");
            int raceCount = sc.nextInt();

            List<Car> cars = CarFactory.produce(carCount);
            RaceCourse raceCourse = new RaceCourse(cars, raceCount);
            raceCourse.startRace();
            raceCourse.viewRaceResult();

        } catch (InputMismatchException e) {
            System.err.println("숫자만 입력할 수 있습니다.");
        } catch (Exception e) {
            System.err.println("에러가 발생 했습니다." + e);
        }

        System.out.println("종료");
    }

}
