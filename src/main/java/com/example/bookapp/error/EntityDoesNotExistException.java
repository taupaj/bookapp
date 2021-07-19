package com.example.bookapp.error;

import lombok.Getter;

/***
 Exception thrown when some entity does not exist. This exception holds entity name and identifier.
 */
@Getter
public class EntityDoesNotExistException extends RuntimeException
{

    private static final long serialVersionUID = 1333020306015555664L;

    private final String entityName;
    private final transient Object entityIdentifier;

    public EntityDoesNotExistException(String entityName, Object entityIdentifier) {
        this.entityName = entityName;
        this.entityIdentifier = entityIdentifier;
    }

    @Override
    public String getMessage() {
        return String.format("Entity '%s' with identifier '%s' does not exist.", entityName, entityIdentifier);
    }
}
