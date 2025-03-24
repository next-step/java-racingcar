package step4;

import java.util.Random;

public class MoveConditions {
    private static final Random random = new Random();

    private MoveConditions() {
        // private 생성자: 객체 생성 방지
        // 사유: util 클래스
    }

    public static MoveCondition randomCondition() {
        return () -> random.nextInt(10) >= 4;
    }

    public static MoveCondition alwaysMove() {
        return () -> true;
    }

    public static MoveCondition neverMove() {
        return () -> false;
    }
}
