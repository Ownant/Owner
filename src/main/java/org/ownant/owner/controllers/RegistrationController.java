package org.ownant.owner.controllers;

import org.ownant.owner.data.OwnerRepository;
import org.ownant.owner.domain.ErrorCode;
import org.ownant.owner.domain.OwnerRecord;
import org.ownant.owner.domain.RegisterOwnerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class RegistrationController {

    @Autowired
    OwnerRepository ownerRepository;

    @PostMapping("/owner/register")
    public OwnerRecord registerNewOwner(@RequestBody RegisterOwnerRequest request) {

        ErrorCode errorCode;
        if (ownerRepository.findAll().stream().anyMatch(record -> record.getEmail().equals(request.getEmail()))) {
            return OwnerRecord.builder().error(ErrorCode.OWNER_EMAIL_ALREADY_PRESENT).build();
        } else if (ownerRepository.findAll().stream().anyMatch(record -> record.getUsername().equals(request.getUsername()))) {
            return OwnerRecord.builder().error(ErrorCode.OWNER_USERNAME_ALREADY_PRESENT).build();
        } else if (null == request.getEmail() || null == request.getUsername() || null == request.getPassword()) {
            return OwnerRecord.builder().error(ErrorCode.INVALID_REQUEST).build();
        } else {
            OwnerRecord record = OwnerRecord.builder()
                    .id(UUID.randomUUID().toString())
                    .name(request.getName())
                    .username(request.getUsername())
                    .password(request.getPassword())
                    .email(request.getEmail())
                    .address(request.getAddress())
                    .build();
            ownerRepository.save(record);
            return record;
        }
    }



}
