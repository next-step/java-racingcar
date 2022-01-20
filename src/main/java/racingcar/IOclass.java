package racingcar;
import java.util.Scanner;

public class IOclass {
    public static String[] getName(){
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        Scanner sc = new Scanner(System.in);
        String str=sc.nextLine();
        String[] cars = str.split(",");
        return cars;
    }
    
    public static boolean checkCarName(String[] carName){
        for(int i=0; i< carName.length; i++){
            if(carName[i].length()>5)
                return false;
        }
        return true;
    } 
    public static int getTimes(){
        System.out.println("시도할 횟수는 몇 회인가요?");
        Scanner sc = new Scanner(System.in);
        int times = sc.nextInt();
        return times;
    }

    public static void printCurrent(String carNames[], int[] cars) {
        for(int i = 0; i < cars.length; i++) {
            System.out.print(carNames[i] + " : ");
            for (int j = 0; j < cars[i]; j++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }

    public static int getMaxScore(int[] cars){
        int maximum=0;
        for (int i = 0; i < cars.length; i++)
            maximum=Math.max(maximum, cars[i]);
        return maximum;
    }
    public static void printWinners(String carNames[], int[] cars) {
        int count=0;
        int maximum = getMaxScore(cars);
        System.out.print("최종 우승자: ");
        for(int i=0; i < cars.length; i++){
            if (cars[i] != maximum)
                continue;
            if (count != 0)
                System.out.print(", ");
            System.out.print(carNames[i]);
            count++;
        }
    }
}