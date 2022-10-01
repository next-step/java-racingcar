package step3.output;

@FunctionalInterface
public interface OutputView {

    void print(int count);

    class Fake implements OutputView {

        @Override
        public void print(int count) {
            System.out.println("(호출완료) count = " + count);
        }
    }
}
