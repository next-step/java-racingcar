package racing.resolver;

public class SimpleAccelerateResolver implements AccelerateResolver {

    private final boolean isProceed;

    public SimpleAccelerateResolver(boolean isProceed) {
        this.isProceed = isProceed;
    }

    @Override
    public boolean resolve() {
        return isProceed;
    }
}
