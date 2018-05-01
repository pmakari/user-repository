package com.k15t.pat.registration.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by MAP2LE on 29.04.2018.
 * All the request DTOs should extend this baseDTO
 */
@Getter@Setter
public abstract class BaseResponseDTO {
    private String message;
}
