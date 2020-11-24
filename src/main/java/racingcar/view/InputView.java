package racingcar.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InputView {
    public Map<Integer, String[]> inputRacingByName(){
        Scanner sc = new Scanner(System.in);

        Map<Integer, String[]> map = new HashMap<>();
    
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String[] racer = sc.nextLine().split(",");
        map.put(0, racer);
        System.out.println("시도할 횟수는 몇회 인가요?");
        String[] move = {sc.nextLine()};
        map.put(1, move);

        sc.close();
        
        return map;
    }
    
}
