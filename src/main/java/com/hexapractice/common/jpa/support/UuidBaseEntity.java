package com.hexapractice.common.jpa.support;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import java.io.Serializable;
import java.util.UUID;

@MappedSuperclass
public class UuidBaseEntity implements Serializable {
    @Id
    @GeneratedValue(generator = "uuid2")
    private UUID id;

    public UUID getId() {
        return id;
    }
}
