package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class ResultView {

    public void print(String out) {
        System.out.print(out);
    }

    public void println(String out) {
        System.out.println(out);
    }

    public void printRoundResult(List<Car> cars) {
        for(Car car : cars) {
            printPosition(car.getPosition(), car.getName());
        }
        println("");
    }

    public void printPosition(int position, String name) {
        System.out.print(name + " : ");
        for (int dash = 0; dash < position; dash++) {
            System.out.print("-");
        }
        println("");
    }

    public void announceWinner(String winners) {
        println("우승자를 발표하겠습니다!!");
        print("우승자는 " + winners);
        print("입니다. 축하합니다!");
    }
}