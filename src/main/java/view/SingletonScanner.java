package view;

import java.util.Scanner;

public class SingletonScanner {

    private SingletonScanner() {
    }

    public static Scanner getInstance() {
        return LazyHolder.INSTANCE;
    }

    public static class LazyHolder {
        private static final Scanner INSTANCE = new Scanner(System.in);
    }

}
