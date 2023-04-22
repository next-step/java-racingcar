package car;

import java.util.Scanner;

public class InputView {


    public int inputIntegerValue(){
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        return Integer.valueOf(value);
    }

    public String inputStringValue(){
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        return value;
    }

    public String[] carAttendNameSeparation(String value){
        return value.split(",");
    }
}
