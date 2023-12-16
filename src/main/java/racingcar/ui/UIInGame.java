package racingcar.ui;

import racingcar.model.Car;

import java.util.Map;

public class UIInGame {
    public void printPlayerCountInput(){
        clearScreen();
        System.out.println("자동차 대수는 몇 대 인가요?");
    }
    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public void printRoundInput(){
        System.out.println("시도할 횟수는 몇 회 인가요?");
    }
    public void printPosition(Integer round, Map<Integer, Car> carList) {
        System.out.println("Round : " + round);
        for (int carNum = 1; carNum <= carList.size(); carNum++) {
            System.out.print(carList.get(carNum).getName()+" : ");
            for (int i = 0; i < carList.get(carNum).getDistance(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }
}
