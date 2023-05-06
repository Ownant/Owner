package org.ownant.owner.data;

import org.ownant.owner.domain.OwnerRecord;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface OwnerRepository extends MongoRepository<OwnerRecord, String> {
}
