package cargameracing;

import java.util.Scanner;

/**
 * Controller Role
 * @author minji
 */
public class CarMain {
    public static void main(String[] args) {
        // CarRacingGameInputView : 입력 View 객체
        CarRacingGameInputView input = new CarRacingGameInputView();
        int carCount = input.getCarCount();
        int playCount = input.getPlayCount();

        // CarRacingGame : 도메인 객체 (자동차 경주 게임에 대한 역할 담당)
        CarRacingGame carRacingGame = new CarRacingGame(carCount);

        System.out.println("실행 결과");
        for (int i = 0; i < playCount; i++) {
            carRacingGame.playGame(new RandomMovingStrategy());
            // CarRacingGameOutputView : 출력 View 객체
            CarRacingGameOutputView.displayResult(carRacingGame.getCars());
            System.out.println();
        }
    }
}
