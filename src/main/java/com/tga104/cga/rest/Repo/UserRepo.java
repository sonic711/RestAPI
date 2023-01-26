package com.tga104.cga.rest.Repo;

import com.tga104.cga.rest.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {



}
