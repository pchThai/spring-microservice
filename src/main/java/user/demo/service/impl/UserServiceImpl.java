package user.demo.service.impl;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import user.demo.entity.User;
import user.demo.repository.UserRepository;
import user.demo.service.UserService;

import java.util.List;
import java.util.Optional;

@Service
@NoArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    @Override
    public User createUser(User user){
      return  userRepository.save(user);
    }
    @Override
    public User getUserById(Long userId){
        Optional<User> optionalUser = userRepository.findById(userId);
        return  optionalUser.get();
    }
    @Override
    public List<User> getAllUser(){
        return userRepository.findAll();
    }
    @Override
    public User updateUser(User user) {
        Optional<User> existingUser = userRepository.findById(user.getId());
        if(!existingUser.isEmpty()){
            existingUser.get().setLastName(user.getLastName());
            existingUser.get().setFirstName(user.getFirstName());
            existingUser.get().setEmail(user.getEmail());
            return userRepository.save(existingUser.get());
        }

        return null;
    }
    @Override
    public void deteleUser(Long userId){
        userRepository.deleteById(userId);
    }
}
