package racingcar.view;

import org.junit.jupiter.api.Test;
import racingcar.service.SystemService;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class RacingCarView{
    SystemService systemService = new SystemService();

    Scanner scan = new Scanner(System.in);
    int cycle = 0;

    public RacingCarView(){
        inputCarInfo();
        inputCycle();
        showResult();
        showWinner();
    }
    @Test
    public void inputCarInfo(){
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input = scan.next();
        systemService.splitString(input);
    }
    @Test
    public void inputCycle() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        cycle = scan.nextInt();
    }
    @Test
    public void showResult(){
        System.out.println("실행결과");
        for(int i=0;i<cycle;i++){
            cycleCarInformation();
        }
    }
    @Test
    public void cycleCarInformation(){
        for(int i = 0; i< systemService.carInfo.size(); i++){
            int movedLocation = systemService.MoveCar(systemService.carInfo.get(i).getLocationInfo());
            systemService.carInfo.get(i).setLocationInfo(movedLocation);

            showCarLocationInfo(systemService.carInfo.get(i).getLocationInfo());
        }
    }
    @Test
    public void showCarLocationInfo(int moveCount){
        for(int i=0;i<moveCount;i++){
            System.out.print("-");
        }
    }
    @Test
    public void showWinner(){
        List<String> winnerName = systemService.checkWinner(cycle);
    }
}
