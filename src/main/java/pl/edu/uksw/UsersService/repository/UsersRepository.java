package pl.edu.uksw.UsersService.repository;

import org.springframework.data.repository.CrudRepository;
import pl.edu.uksw.UsersService.entity.User;

import javax.jws.soap.SOAPBinding;
import java.util.List;

/**
 * Created by Nogaz on 06.07.2017.
 */
public interface UsersRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);
    List<User> findAll();

}
