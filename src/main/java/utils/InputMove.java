package utils;

import java.util.Scanner;

public class InputMove {
    public static int inMove() {
        Scanner sc = new Scanner(System.in);
        int moveCount;
        try {
            String moveCountStr = sc.next();
            moveCount = Integer.parseInt(moveCountStr);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자만 입력해주세요.");
        }

        return moveCount;
    }
}
