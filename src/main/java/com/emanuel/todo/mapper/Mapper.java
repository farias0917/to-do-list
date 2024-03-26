package com.emanuel.todo.mapper;

import java.util.List;

public interface Mapper<E, D> {
    public D fromEntityToDto(E e);

    public E fromDtoToEntity(D d);
}
