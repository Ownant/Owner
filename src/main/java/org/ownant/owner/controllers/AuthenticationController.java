package org.ownant.owner.controllers;

import org.ownant.owner.data.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    @Autowired
    OwnerRepository ownerRepository;

    @GetMapping("/owner/authentication")
    public ResponseEntity authenticate(@RequestHeader String username, @RequestHeader String password, @RequestHeader String ownerId) {

        if (ownerRepository.findById(ownerId).isPresent()
                && ownerRepository.findById(ownerId).get().getUsername().equals(username)
                && ownerRepository.findById(ownerId).get().getPassword().equals(password)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
