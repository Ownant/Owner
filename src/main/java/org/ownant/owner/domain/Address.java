package org.ownant.owner.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Address {
    String line1;
    String line2;
    BigDecimal zipCode;
    String city;
}
