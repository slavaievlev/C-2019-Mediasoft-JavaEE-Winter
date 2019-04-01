package ru.slavaievlev.service;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.slavaievlev.db.model.City;
import ru.slavaievlev.db.model.User;
import ru.slavaievlev.db.model.enums.Role;
import ru.slavaievlev.db.model.enums.UserState;
import ru.slavaievlev.db.repository.ICityRepository;
import ru.slavaievlev.db.repository.IUserRepository;
import ru.slavaievlev.dto.UserDto;

import java.util.Optional;

@Service
public class UserService implements IUserService{

    private IUserRepository userRepository;
    private ICityRepository cityRepository;

    @Autowired
    public UserService(IUserRepository userRepository, ICityRepository cityRepository) {
        this.userRepository = userRepository;
        this.cityRepository = cityRepository;
    }

    public void authorization(UserDto userDto) throws Exception {
        authentication(userDto);
    }

    private User authentication(UserDto userDto) throws Exception {
        Optional<User> findUser =  userRepository.getByLogin(userDto.getLogin());
        if(!findUser.isPresent()) {
            throw new Exception("User with current login not fount");
        }

        if (encodePassword(userDto.getPassword())
                .equals(findUser.get().getPassword())) {
            return findUser.get();
        }
        throw new Exception("Password not correct");
    }

    public void registration(UserDto userDto) throws Exception {
        User newUser = new User();
        newUser.setLogin(userDto.getLogin());
        newUser.setFirstName(userDto.getFirstName());
        newUser.setLastName(userDto.getLastName());
        newUser.setRole(Role.USER);
        newUser.setState(UserState.ACTIVE);

        newUser.setPassword(encodePassword(userDto.getPassword()));

        Optional<City> findCity = cityRepository.getByName(userDto.getCityName());
        if(!findCity.isPresent()) {
            throw new Exception("City not found");
        }
        newUser.setCity(findCity.get());

        userRepository.saveAndFlush(newUser);
    }

    private String encodePassword(String sourcePassword) {
        return DigestUtils.md5Hex(sourcePassword);
    }
}
