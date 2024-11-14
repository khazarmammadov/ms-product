package org.khazar.products.exception;

import lombok.Builder;

@Builder
public record ErrorResponse(String message) {
}
