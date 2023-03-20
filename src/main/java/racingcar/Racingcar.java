package racingcar;

/*
 * 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
 * 각 자동차에 이름을 부여할 수 있다. 자동차 이름은 5자를 초과할 수 없다.
 * 자동차 이름은 쉼표(,)를 기준으로 구분한다.
 * 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
 * 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
 * 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
 * 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.
 * 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
*/

import java.util.Scanner;

public class Racingcar {

    public static String[] split(String input) {
        Double result = (double) 0L;

        if(input == null || "".equals(input)) {
            throw new IllegalArgumentException();
        }
        String[] split = input.split(",");

        return split;
    }

    public static void execute(int cnt, Car cars[]) {
        for (int i = 0; i < cnt; i++) {
            if(cars[i].rand() > 4) {
                cars[i].moveCar();
            }
        }
    }

    public static void print(Car cars[]) {
        for (Car car:cars) {
            System.out.print(car.name + " : " );
            for (int i = 0; i < car.location; i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        // pobi,woni,jun
        System.out.print("이름입력(구분자 : ',') : ");
        String input = sc.nextLine();
        System.out.print("수행횟수 : ");
        int exeCnt = sc.nextInt();

        String[] split = split(input);
        Car[] cars = new Car[split.length];

        int cnt = 0;
        for (String s :split) {
            if(s.length() > 5) {
                throw new IllegalArgumentException();
            }

            cars[cnt] = new Car(s,0);
            cnt++;
        }

        for (int i = 0; i < exeCnt; i++) {
            execute(split.length, cars);
            print(cars);
        }

    }
}
