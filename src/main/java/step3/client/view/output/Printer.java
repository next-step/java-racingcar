package step3.client.view.output;

import step3.worker.interfaces.render.ViewString;

public class Printer {
    public static void println(final ViewString x) {
        System.out.println(x);
    }

    public static void print(final String x) {
        System.out.print(x);
    }
}