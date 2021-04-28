package racingcar.view;

import racingcar.service.SystemService;

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
    public void inputCarInfo(){
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input = scan.next();
        systemService.splitString(input);
    }
    public void inputCycle() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        cycle = scan.nextInt();
    }
    public void showResult(){
        System.out.println("실행결과");
        for(int i=0;i<cycle;i++){
            cycleCarInformation();
        }
    }
    public void cycleCarInformation(){
        for(int i = 0; i< systemService.carInfo.size(); i++){
            System.out.print(systemService.carInfo.get(i).getName());
            System.out.print(systemService.carInfo.get(i).getLocationInfo());
        }
    }
    public void showWinner(){
        System.out.print("최종 우승자 : ");
    }
}
