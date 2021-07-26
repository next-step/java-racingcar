package racing.util.converter;

public interface Converter<T, R> {
    R convert(T input);
}
