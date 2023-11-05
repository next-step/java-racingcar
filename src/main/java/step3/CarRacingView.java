package step3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CarRacingView {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        CarRacing carRacing = new CarRacing();

        while (true) {
            System.out.println("자동차 대수는 몇 대 인가요?");
            int numOfCar = Integer.parseInt(br.readLine());

            System.out.println("시도할 횟수는 몇 회 인가요?");
            int numOfTry = Integer.parseInt(br.readLine());

            System.out.println("실행 결과");
        }
    }
}
