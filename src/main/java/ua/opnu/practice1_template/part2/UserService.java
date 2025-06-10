package ua.opnu.practice1_template.part2;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ua.opnu.practice1_template.part2.Role;
import ua.opnu.practice1_template.part2.User;
import ua.opnu.practice1_template.model.Student;
import ua.opnu.practice1_template.part2.UserRepository;
import ua.opnu.practice1_template.part2.payload.SignUpRequest;
import ua.opnu.practice1_template.repository.StudentRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }


    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public User registerStudent(SignUpRequest signUpRequest) {
        User user = new User();
        user.setUsername(signUpRequest.getUsername());
        if (existsByUsername(signUpRequest.getUsername())) {
            throw new RuntimeException("Username is already taken");
        }

        if (existsByEmail(signUpRequest.getEmail())) {
            throw new RuntimeException("Email is already in use");
        }


        user.setEmail(signUpRequest.getEmail());
        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        user.setRole(Role.ROLE_STUDENT);

        User savedUser = userRepository.save(user);

        Student student = new Student();
        student.setName(user.getUsername());
        student.setEmail(user.getEmail());
        student.setUser(savedUser);
        studentRepository.save(student);

        return savedUser;
    }


}
