package ultimate.systems.study.service.mapper;

public interface ResponseDtoMapper<D, T> {
    D mapToDto(T t);
}
