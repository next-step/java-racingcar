package carracing;

import java.util.List;

public class Output {
    public String condition(int position) {
        String line = "";
        for (int i = 0; i < position; i++) {
            line += "-";
        }
        return line;
    }

    public void showCarStatus(List<Car> cars, int racingCount) {
        RandomNumber randomNumber = new RandomNumber();
        for (int i = 0; i < racingCount; i++) {
            for (int j = 0; j < cars.size(); j++) {
                cars.get(j).move(randomNumber.createRandomNumber());
                System.out.println(cars.get(j).getCarName() + " : " + condition(cars.get(j).getPosition()));
            }
            System.out.println();
        }
    }

    public void showWinner(List<Car> cars) {
        CarRacing carRacing = new CarRacing();
        List<String> winnerList = carRacing.makeWinners(cars);
        System.out.println("최종 우승자: " + winnerList.toString().replaceAll("\\[", "").replaceAll("\\]", ""));
    }
}