package user.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import user.demo.entity.User;
@Repository
public interface UserRepository  extends JpaRepository<User,Long> {

}
