package racing.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final List<Car> Cars;
    private int maxPosition;

    public RacingGame() {
        this.Cars = new ArrayList<>();
        this.maxPosition = 0;
    }

    public void startGame() {
        List<String> nameList = UserInput.getCarNames();
        int tryNumber = UserInput.getTryNumber();
        for (String name : nameList) {
            Cars.add(new Car(name));
        }

        startRacing(tryNumber);
        showGameResult();
    }

    private void startRacing(int tryNumber) {
        System.out.println("\n실행 결과");
        for (int i = 0; i < tryNumber; i++) {
            driveCars();
            System.out.println();
        }
    }

    private int generateRandomNumber() {
        return (int) (Math.random() * 9);
    }

    private void driveCars() {
        for (Car car : Cars) {
            int randomNumber = generateRandomNumber();
            int position = car.drive(randomNumber);
            setMaxPosition(position);
        }
    }

    private void setMaxPosition(int position) {
        if (position > maxPosition) {
            maxPosition = position;
        }
    }

    private void showGameResult() {
        StringBuilder sb = new StringBuilder();
        for (Car car : Cars) {
            sb.append(car.checkWinner(maxPosition));
        }
        sb.setLength(sb.length() - 2);

        System.out.println("최종 우승자 : " + sb);
    }
}
