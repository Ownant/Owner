package org.ownant.owner.controllers;

import org.ownant.owner.data.OwnerRepository;
import org.ownant.owner.domain.ErrorCode;
import org.ownant.owner.domain.OwnerRecord;
import org.ownant.owner.domain.TenantActivationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class TenantEnrollmentController {
    @Autowired
    OwnerRepository ownerRepository;

    @PostMapping("/owner/enrollTenant")
    public TenantActivationResponse generateNewTenantEnrollmentCode(@RequestHeader String username, @RequestHeader String password) {
        if (ownerRepository.findAll().stream()
                .anyMatch(record -> record.getUsername().equals(username)
                        && record.getPassword().equals(password))) {
            OwnerRecord record = ownerRepository.findAll().stream().filter(r -> r.getUsername().equals(username)).findFirst().get()
                    .toBuilder().tenantActivationCode(UUID.randomUUID().toString()).build();

            ownerRepository.deleteById(record.getId());
            ownerRepository.save(record);

            return TenantActivationResponse.builder()
                    .tenantActivationCode(record.getTenantActivationCode())
                    .build();
        } else {
            return TenantActivationResponse.builder()
                    .error(ErrorCode.OWNER_NOT_PRESENT)
                    .build();
        }

    }
}
