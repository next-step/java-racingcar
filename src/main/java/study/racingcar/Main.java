package study.racingcar;

import java.util.Scanner;
import study.racingcar.controller.GameBoard;

public class Main {
    public static void main(String[] args) {
        GameBoard gameBoard = new GameBoard(new Scanner(System.in), System.out);
        gameBoard.racingGameStart();
    }
}
