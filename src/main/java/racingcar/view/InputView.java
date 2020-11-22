package racingcar.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    public List<String> inputRacingByName(){
        Scanner sc = new Scanner(System.in);

        List<String> racingRule = new ArrayList<>();
    
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        racingRule.add(sc.nextLine());
        System.out.println("시도할 횟수는 몇회 인가요?");
        racingRule.add(sc.nextLine());

        sc.close();
        
        return racingRule;
    }
    
}
