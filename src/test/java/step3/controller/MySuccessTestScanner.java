package step3.controller;

public class MySuccessTestScanner implements ScannerInterface {

    @Override
    public String getNext() {
        return "5";
    }

    @Override
    public int getNextInt() {
        return 4;
    }
}
