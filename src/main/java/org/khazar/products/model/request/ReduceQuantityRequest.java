package org.khazar.products.model.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.khazar.products.model.constants.ApplicationConstants;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReduceQuantityRequest {

    @NotNull(message = ApplicationConstants.PRODUCT_ID_IS_REQUIRED)
    private Long productId;
    @NotNull(message = ApplicationConstants.QUANTITY_IS_REQUIRED)
    private Integer quantity;
}
