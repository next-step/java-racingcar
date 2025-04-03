package carrace.utils;

public class InputValidator {

    public static Integer receiveCarNum(int numCar) {
        System.out.println("자동차 대수는 몇 대 인가요?");
        if (numCar > 0) {
            return numCar;
        }
        throw new RuntimeException("자동차 대수는 1 이상의 값이어야합니다.");
    }

    public static Integer receiveNumTry(int numTry) {
        System.out.println("시도할 회수는 몇 회 인가요?");
        if (numTry > 0) {
            return numTry;
        }
        throw new RuntimeException("시도할 회수는 1 이상의 값이어야 합니다.");
    }
}
