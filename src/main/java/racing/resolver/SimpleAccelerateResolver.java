package racing.resolver;

public class SimpleAccelerateResolver extends AccelerateResolver {

    boolean isProceed;

    public SimpleAccelerateResolver(boolean isProceed) {
        this.isProceed = isProceed;
    }

    @Override
    public boolean resolve() {
        return isProceed;
    }
}
