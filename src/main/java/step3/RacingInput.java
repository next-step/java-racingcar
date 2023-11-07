package step3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RacingInput {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void inputNumOfCars(CarRacing carRacing) throws IOException {
        int numOfCar = Integer.parseInt(br.readLine());
        carRacing.createCarsOf(numOfCar);
    }

    public int inputNumOfTry() throws IOException {
        return Integer.parseInt(br.readLine());
    }
}
