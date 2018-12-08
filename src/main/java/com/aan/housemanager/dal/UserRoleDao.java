package com.aan.housemanager.dal;

import org.springframework.data.repository.CrudRepository;

import com.aan.housemanager.model.UserRole;

public interface UserRoleDao extends CrudRepository<UserRole, Integer> {

}