package racingcar;
import java.util.Scanner;

public class InputView {
    public static String[] getName(){
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        Scanner sc = new Scanner(System.in);
        String str=sc.nextLine();
        return str.split(",");
    }

    public static int getTimes(){
        System.out.println("시도할 횟수는 몇 회인가요?");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public static boolean checkCarName(String[] carName){
        for (int i=0; i< carName.length; i++) {
            if (carName[i].length() > 5)
                return false;
        }
        return true;
    }
}
