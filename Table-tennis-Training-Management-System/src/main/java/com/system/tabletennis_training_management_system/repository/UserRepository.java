package com.system.tabletennis_training_management_system.repository;

import com.system.tabletennis_training_management_system.pojo.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

}
