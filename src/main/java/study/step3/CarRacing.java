package study.step3;

import java.util.Objects;
import java.util.Scanner;

public class CarRacing {

    /**
     *
     *
     *
     *
     * 시도 회수 반복문 START
     * 자동차 대수 반복문 START
     * 전진 조건 생성, 0`MIN_RANDOM_VALUE`에서 9`MAX_RANDOM_VALUE` 사이에서 random 값
     * 전진 조건 체크, 4`MIN_FORWARD_VALUE` 이상인 경우 1칸("-", `MOVE_FORWARD`) 이동
     * 자동차 대수 반복문 END
     * 시도 회수 반복문 END
     * 시도 회수별로 자동차 이동시, 라인별 `-`을 추가하는 형식으로 출력
    * */
    private int MIN_INPUT_NUMBER = 1;
    private int MIN_RANDOM_NUMBER = 0;
    private int MAX_RANDOM_NUMBER = 9;
    private int MIN_FORWARD_NUMBER = 4;
    private int MOVE_NUMBER = 1;

    public static void main(String[] args){
        Car car = extractRequestValue();

//        car.
    }

    private static Car extractRequestValue() {
        Scanner scanner = new Scanner(System.in);
        // "자동차 대수는 몇 대 인가요?" 출력
        System.out.println("자동차 대수는 몇 대 인가요?");
        // 자동차 대수 입력 -> (입력값이 1`MIN_INPUT_NUMBER`보다 크거나 같은 정수인지 Validation Check)
        String carCount = scanner.nextLine();
        validateValue(carCount);
        // "시도할 회수는 몇 회 인가요?" 출력
        System.out.println("시도할 회수는 몇 회 인가요?");
        // 시도할 회수 입력 -> (입력값이 1`MIN_INPUT_NUMBER`보다 크거나 같은 정수인지 Validation Check)
        String tryCount = scanner.nextLine();
        validateValue(tryCount);
        // String tryCount = scanner.nextLine();
        System.out.println("car Number: " + carCount + " | try number: " + tryCount);

        return new Car(carCount, tryCount);
    }

    private static void validateValue(String param){
        if(Objects.isNull(param) || param.isEmpty()){
            throw new IllegalArgumentException("입력 문자열이 정상적이지 않습니다.");
        }
    }

}
