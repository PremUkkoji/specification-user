package com.premukkoji.user.service;

import com.premukkoji.user.entity.User;
import com.premukkoji.user.model.FilterRequest;
import com.premukkoji.user.repository.UserRepository;
import com.premukkoji.user.specification.SearchCriteria;
import com.premukkoji.user.specification.UserSpecification;
import com.premukkoji.user.specification.UserSpecificationsBuilder;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAllUsers(FilterRequest filterRequest){
        UserSpecificationsBuilder userSpecificationsBuilder = new UserSpecificationsBuilder();

        filterRequest.getFilters().forEach(filter -> userSpecificationsBuilder.with(
                filter.getKey(), filter.getOperator(), filter.getValue()
        ));

        Specification<User> spec = userSpecificationsBuilder.build();

        return userRepository.findAll(spec);
    }

    public List<User> getUsersLessThanAge25() {
        UserSpecification userSpecification = new UserSpecification(
                new SearchCriteria("age", ">", 25)
        );
        return userRepository.findAll(userSpecification);
    }

    public void save(User user){
        userRepository.save(user);
    }
}
