package View;

import Model.Car;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Input {
    private Scanner scanner = new Scanner(System.in);
    public ArrayList<Car> getName() throws IllegalArgumentException{
        ArrayList<Car> carList = new ArrayList<Car>();
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String nameStr;
        try {
            nameStr = scanner.next();
        }
        catch(Exception e){throw new IllegalArgumentException();}
        StringTokenizer token = new StringTokenizer(nameStr, ",");
        while (token.hasMoreTokens()){
            carList.add(new Car(token.nextToken()));
        }
        return carList;
    }

    public int getCount() throws IllegalArgumentException{
        System.out.println("시도할 회수는 몇회인가요?");
        int num;
        try {
            num = scanner.nextInt();
        }
        catch(Exception e) {throw new IllegalArgumentException();}
        return num;
    }
}
