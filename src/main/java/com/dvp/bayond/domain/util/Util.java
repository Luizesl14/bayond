package com.dvp.bayond.domain.util;

import com.dvp.bayond.service.exception.NullObjectException;

import java.lang.reflect.Field;
import java.util.Objects;
import java.util.Optional;

public abstract class Util {

    public Boolean vetifyFilds(String pacote) throws ClassNotFoundException {
        Class<?> classe = Class.forName(pacote);

        Field[] attributes = classe.getDeclaredFields();

        boolean parametro_null = false;
        for(Field x : attributes){
            x.setAccessible(true);
          parametro_null = Optional.of(x).stream().anyMatch(Objects::isNull);

        }
        return parametro_null;
    }
}
