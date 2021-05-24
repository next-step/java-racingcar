package racingcargame.view;

import racingcargame.model.RacingCar;

import java.util.List;
import java.util.Scanner;

public class RacingCarGameOutputView {
    public void outputRound(List<RacingCar> cars) {
        for (RacingCar car : cars) {
            System.out.println(car.getName() + " : " + showStep(car.getStep()));
        }
        System.out.println();
    }

    public String showStep(int step) {
        StringBuilder bar = new StringBuilder();
        for (int i = 0; i < step; i++) {
            bar.append("-");
        }
        return bar.toString();
    }

    public void outputWinners(String winners) {
        System.out.println("최종 우승자:" + winners);
    }

    public static void main(String[] args) {
        Scanner c = new Scanner(System.in);
        String name = c.nextLine();
        System.out.println(name);
    }
}
