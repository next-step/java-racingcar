package racingcar;
import java.util.Scanner;

public class IOclass {
    public static String[] getName(){
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        Scanner sc = new Scanner(System.in);
        String str=sc.nextLine();
        String[] cars = str.split(",");
        return cars;
    }
}
