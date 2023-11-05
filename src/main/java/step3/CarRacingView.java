package step3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CarRacingView {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        CarRacing carRacing = new CarRacing();
        Drawing drawing = new Drawing();

        System.out.println("자동차 대수는 몇 대 인가요?");
        int numOfCar = Integer.parseInt(br.readLine());
        carRacing.createCarsOf(numOfCar);

        System.out.println("시도할 횟수는 몇 회 인가요?");
        int numOfTry = Integer.parseInt(br.readLine());

        System.out.println("실행 결과");

        for (int i=0; i<numOfTry; i++) {
            carRacing.moveCar();

            int[] positions = findPositions(carRacing);
            drawing.drawCarRacing(positions, numOfCar);

            System.out.println();
        }
    }

    private static int[] findPositions(CarRacing carRacing) {
        int numOfCar = carRacing.getCars().getNumOfCars();

        int[] positions = new int[numOfCar];
        for (int i=0; i<numOfCar; i++) {
            positions[i] = carRacing.getCars().findCarBy(i).getCurrentPosition();
        }

        return positions;
    }


}
