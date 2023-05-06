package org.ownant.owner.domain;

import lombok.Data;

@Data
public class RegisterOwnerRequest {
    String name;
    String username;
    String password;
    String email;
    Address address;
}
