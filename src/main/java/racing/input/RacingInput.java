package racing.input;

import racing.domain.Car;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RacingInput {

    private Scanner scanner;

    public RacingInput(InputStream inputStream) {
        this.scanner = new Scanner(inputStream);
    }

    public List<Car> inputName() {
        return Arrays.stream(this.scanner.next().split(","))
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public int inputCount() {
        return this.scanner.nextInt();
    }
}
