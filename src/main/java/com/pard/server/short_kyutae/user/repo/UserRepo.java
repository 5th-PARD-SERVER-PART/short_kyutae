package com.pard.server.short_kyutae.user.repo;






import com.pard.server.short_kyutae.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepo extends JpaRepository<User, Long> {

}
