package com.project.uber.Service;

import com.project.uber.Dto.UserDetailsDto;
import com.project.uber.Entity.LoginUser;
import com.project.uber.Entity.UserDetails;
import com.project.uber.Repository.LoginUserRepository;
import com.project.uber.Repository.UserDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserDetailsRepository userDetailsRepository;
    private final LoginUserRepository loginUserRepository;

    @Transactional
    public String registerUser(UserDetailsDto userDetailsDto) {

        Optional<LoginUser> loginUser = loginUserRepository.findById(userDetailsDto.getUserId());


        if(loginUser.isEmpty()) {
            return "No login_user with id " + userDetailsDto.getUserId();
        }

        if (userDetailsRepository.existsByUserId(userDetailsDto.getUserId())) {
          //  throw new IllegalStateException(
            return "UserDetails already exists for user_id " + userDetailsDto.getUserId();
        }

        UserDetails entity = new UserDetails();
        entity.setUserId(loginUser.get().getId());
        entity.setIsElectrician(Boolean.TRUE.equals(userDetailsDto.getIsElectrician()));
        entity.setIsCustomer(Boolean.TRUE.equals(userDetailsDto.getIsCustomer()));
        entity.setIsActive(userDetailsDto.getIsActive() == null || userDetailsDto.getIsActive());
        entity.setIsDeleted(false);

        userDetailsRepository.save(entity);

        return "User registered successfully!";
    }
}