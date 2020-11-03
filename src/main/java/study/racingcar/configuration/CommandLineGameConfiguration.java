package study.racingcar.configuration;

import study.racingcar.car.Car;
import study.racingcar.car.moving.CarMovingStrategy;
import study.racingcar.view.InputView;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 게임의 설정을 입력받아 게임을 초기화하는 책임
 */
public class CommandLineGameConfiguration extends AbstractGameConfiguration {

    public CommandLineGameConfiguration(InputView inputView, CarMovingStrategy strategy) {

        Scanner scanner = new Scanner(System.in);

        inputView.numberOfCarsMessage();
        this.numberOfCars = scanner.nextInt();

        inputView.numberOfTriesMessage();
        this.numberOfTries = scanner.nextInt();

        this.strategy = strategy;

        validate();
    }


    @Override
    public boolean doMoreTry(int count) {
        return this.numberOfTries > count;
    }
}
