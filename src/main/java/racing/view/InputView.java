package racing.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InputView {

    private static Scanner sc = new Scanner(System.in);
    private static Map<Integer,String> carMap = new HashMap<Integer, String>();

    public static int numOfCars(){

        System.out.println("자동차 대수는 몇 대 인가요? ");

        return sc.nextInt();

    }

    public static String[] numOfCarsByNames(){

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return sc.next().split(",");
    }

    public static int times(){

        System.out.println("시도할 회수는 몇 회 인가요?");

        return sc.nextInt();

    }

}
