package step2.FourOperation;

public interface Operation {

    Operation NONE = new Operation() {
        @Override
        public int operation(int n, int m) {
            return 0;
        }
    };
    public int operation(int n, int m);
}
