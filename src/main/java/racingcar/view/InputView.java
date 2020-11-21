package racingcar.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    public List<Integer> inputRacingByCarNum(){
        Scanner sc = new Scanner(System.in);

        List<Integer> racingRule = new ArrayList<>();
    
        System.out.println("자동차 대수는 몇 대 인가요?");
        racingRule.add(sc.nextInt());
        System.out.println("시도할 횟수는 몇회 인가요?");
        racingRule.add(sc.nextInt());

        sc.close();
        
        return racingRule;
    }

    public List<String> inputRacingByName(){
        Scanner sc = new Scanner(System.in);

        List<String> racingRule = new ArrayList<>();
    
        System.out.println("자동차 대수는 몇 대 인가요?");
        racingRule.add(sc.nextLine());
        System.out.println("시도할 횟수는 몇회 인가요?");
        racingRule.add(sc.nextLine());

        sc.close();
        
        return racingRule;
    }
    
}