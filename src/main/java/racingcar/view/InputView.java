package racingcar.view;

import java.util.Scanner;

public class InputView {

    private String[] carNames;
    private int time;

    public InputView() { }

    public String[] getCarNames() { return carNames; }
    public int getTime() { return time; }

    public void inputSetting(){
        Scanner sc = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,))를 기준으로 구분");
        carNames = sc.next().split(",");

        System.out.println("시도할 회수는 몇 회 인가요?");
        time = sc.nextInt();
    }

}
