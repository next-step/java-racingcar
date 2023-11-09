package step4;

import step4.controller.CarRacingController;
import step4.view.CarRacingInputView;
import step4.view.InputDto;
import step4.view.MyScanner;
import step4.view.ScannerInterface;

import java.util.List;
import java.util.Scanner;

public class CarRacing {


    private static final ScannerInterface myScanner = new MyScanner(new Scanner(System.in));

    public static void main(String[] args) {

        CarRacingInputView carRacingInputView = new CarRacingInputView(myScanner);
        InputDto inputDto = carRacingInputView.inputRacingCondition();

        CarRacingController carRacingController = new CarRacingController(inputDto);
        carRacingController.carRacing();
    }
}
