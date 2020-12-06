package step4.domain.judge;

public interface Judge<T,R> {
    T judge(R r);
}
