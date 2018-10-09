package com.barclays.statements.Repositories;

import com.barclays.statements.Models.Rules;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RulesRepository extends MongoRepository<Rules, String> {
}
