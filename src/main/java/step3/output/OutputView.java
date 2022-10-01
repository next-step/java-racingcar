package step3.output;

@FunctionalInterface
public interface OutputView {

    void print(int i);

    class Fake implements OutputView {

        @Override
        public void print(int i) {
            System.out.println("(호출완료) i = " + i);
        }
    }
}
