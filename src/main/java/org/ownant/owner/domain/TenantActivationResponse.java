package org.ownant.owner.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TenantActivationResponse {
    String  tenantActivationCode;
    ErrorCode error;
}
