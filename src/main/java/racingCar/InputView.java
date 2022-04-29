package racingCar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    Scanner scanner = new Scanner(System.in);


    public int numberOfCar(){
        System.out.println("자동차 대수는 몇 대 인가요?");
        return scanner.nextInt();
    }


    public List<String> nameList(){
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String[] temporaryArray = scanner.nextLine().split(",");
        return new ArrayList<>(Arrays.asList(temporaryArray));
    }

    public int numberOfGame(){
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }


}
