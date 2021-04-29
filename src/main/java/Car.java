import java.util.Scanner;
import java.util.Random;

public class Car {
    public void outputName() {
        System.out.print("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }
    public String inputName() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    public void outputNumber() {
        System.out.print("시도할 횟수는 몇 회인가요?");
    }
    public int inputNumber() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
    public String result() {
        outputName();
        String name = inputName();
        outputNumber();
        int number = inputNumber();
        System.out.println("실행 결과");
        String[] cars = splitComma(name);
        int[] carsGo = new int[cars.length];
        for (int i = 0; i < number; i += 1) {
            for (int j = 0; j < cars.length; j += 1) {
                System.out.print(cars[j] + " : ");
                Random random = new Random();
                int a = random.nextInt(10);
                if (a >= 4) {
                    carsGo[j] += 1;
                }
                for (int k = 0; k < carsGo[j]+1; k += 1) {
                    System.out.print("-");
                }
            }
        }
        System.out.print("최종 우승자: ");
        int maxScore = 0;
        for (int i = 0; i < carsGo.length; i += 1) {
            if (maxScore < carsGo[i]) maxScore = carsGo[i];
        }
        int j = 0;
        for (j = 0; j < carsGo.length; j += 1) {
            if (carsGo[j] == maxScore) break;
        }
        System.out.println(cars[j]);
        return cars[j];
    }
    public String[] splitComma(String str) {
        return str.split(",");
    }
}
