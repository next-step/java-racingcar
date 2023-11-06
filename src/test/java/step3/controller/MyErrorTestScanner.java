package step3.controller;

public class MyErrorTestScanner implements ScannerInterface {

    @Override
    public String getNext() {
        return "5";
    }

    @Override
    public int getNextInt() {
        return -4;
    }
}
