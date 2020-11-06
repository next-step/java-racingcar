package racing.resolver;

public class SimpleAccelerateResolver implements AccelerateResolver {

    boolean isProceed;

    public SimpleAccelerateResolver(boolean isProceed) {
        this.isProceed = isProceed;
    }

    @Override
    public boolean resolve() {
        return isProceed;
    }
}
