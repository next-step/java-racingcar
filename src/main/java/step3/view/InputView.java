package step3.view;

import java.util.Scanner;

public class InputView {

    /*
        Scanner 클래스를 필드로 빼면 test에서 실패.
        (원인) 필드로 선언하면 모든 메서드에서 같은 Scanner 객체를 공유하므로 System.in을 사용하면
               Scanner 객체가 close 되어서 다음 메서드에서 사용이 불가능.
        (해결법1) Scanner 객체를 메서드 내 지역변수로 독립적으로 선언.
        (해결법2) BufferedReader 객체는 자동으로 입력 스트림을 닫는 기능이 없으므로 이 객체를 사용.
        (선택) 요구사항에 Scanner API를 사용하라고 적혀있었으므로 해결법1을 택함.
    */

    public static int putNumOfCars () {
        Scanner sc = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        return sc.nextInt();
    }

    public static int putNumOfAttempts() {
        Scanner sc = new Scanner(System.in);
        System.out.println("시도할 횟수는 몇 회 인가요?");
        return sc.nextInt();
    }
}
