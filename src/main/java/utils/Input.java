package utils;

import java.util.Scanner;

public class Input {

    private static Scanner sc = new Scanner(System.in);

    public static int inMoveCount() {
        int moveCount = 0;
        try {
            String moveCountStr = sc.next();
            moveCount = Integer.parseInt(moveCountStr);
        }catch (NumberFormatException e){
            throw new NumberFormatException("숫자만 입력해주세요.");
        }
        return moveCount;
    }
}
