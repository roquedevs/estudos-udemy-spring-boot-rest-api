package com.github.roquedevs.dto;

import java.io.Serial;
import java.io.Serializable;

public record PersonDTO(Long id,
                        String firstName,
                        String lastName,
                        String email,
                        String phone,
                        String address) implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

}
