package carrace.view.input.scanner;

import carrace.domain.CarName;

import java.util.ArrayList;
import java.util.List;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.PatternSyntaxException;

public class NameInputScanner implements InputScanner<List<CarName>> {

    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public List<CarName> scan() {
        String[] carNames = scanner.nextLine().split(",");

        List<CarName> carNameList = new ArrayList<>();
        for (String carname : carNames) {
            carNameList.add(new CarName(carname));
        }
        return carNameList;
    }

    @Override
    public List<CarName> repeatScan(String message) {
        while(true) {
            try {
                System.out.println(message);
                return this.scan();
            } catch (PatternSyntaxException | NoSuchElementException ex) {
                System.out.println("이름 입력 양식이 올바르지 않습니다.");
            } catch (IllegalArgumentException ex) {
                System.out.println("자동차 이름이 5자 이상입니다.");
            }
        }
    }
}
