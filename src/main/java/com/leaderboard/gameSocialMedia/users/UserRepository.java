package com.leaderboard.gameSocialMedia.users;

import com.leaderboard.gameSocialMedia.users.Users;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Users, Integer> {
    public Users findByUsername(String username);
    Users grabPassword(String username);
}
