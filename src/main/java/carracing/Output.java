package carracing;

import java.util.List;

public class Output {
    private static final String DASH = "-";

    public void showInputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public void showInputRacingCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public StringBuilder changeCarPosition(int position) {
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < position; i++) {
            line.append(DASH);
        }
        return line;
    }

    public void showCarStatus(List<Car> cars, int racingCount) {
        RandomNumber randomNumber = new RandomNumber();
        for (int i = 0; i < racingCount; i++) {
            for (Car car : cars) {
                car.move(randomNumber.createRandomNumber());
                System.out.println(car.getCarName() + " : " + changeCarPosition(car.getPosition()));
            }
            System.out.println();
        }
    }

    public void showWinner(CarRacing carRacing) {
        System.out.println("최종 우승자: " + carRacing.makeWinners().toString().replaceAll("\\[", "").replaceAll("\\]", ""));
    }
}