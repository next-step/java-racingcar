package racing.view;

import java.util.Scanner;

public class InputView {

    private Scanner sc = new Scanner(System.in);

    public int numOfCars(){

        System.out.println("자동차 대수는 몇 대 인가요? ");

        return sc.nextInt();

    }

    public int times(){

        System.out.println("시도할 회수는 몇 회 인가요?");

        return sc.nextInt();

    }

}
