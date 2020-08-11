package cc.oakk.racing.domain.converter;

public interface Converter<T, E> {
    E convert(T from);
}
