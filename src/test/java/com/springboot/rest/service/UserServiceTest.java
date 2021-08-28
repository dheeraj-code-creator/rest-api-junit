package com.springboot.rest.service;

import com.springboot.rest.dto.UserDto;
import com.springboot.rest.entity.User;
import com.springboot.rest.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Mock
    private ConverterService converterService;

    @MockBean
    private UserRepository userRepository;

    // when u r writing test case then forget about DB, whatever value u r mocking that value will be evaluate
    // in service class. (based on the mock value we are checking whether the methods are working properly or not)

    @Test
    public void getAllUserInfoTest() {
        List<User> userList = new ArrayList<>();
        User user = new User("555", "Dheeraj");
        userList.add(user);
        Mockito.when(userRepository.findAll()).thenReturn(userList);
        Assert.assertEquals(1,userService.getAllUserInfo().size());
        Assert.assertEquals("555",userService.getAllUserInfo().get(0).getUserId());
        Assert.assertNotNull(userService.getAllUserInfo().size());
    }

    @Test
    public void getUserByIdTest(){
        String id = "898";
        User user = new User("898", "Banti");
        Mockito.when(userRepository.findById(id)).thenReturn(java.util.Optional.of(user));
        Mockito.when(converterService.convertToDto(user)).thenReturn(new UserDto());
        Assert.assertEquals("898",userService.getUserByUserId(id).getUserId());
        Assert.assertEquals("Banti",userService.getUserByUserId(id).getUserName());
        Assert.assertNotNull(userService.getUserByUserId(id));
    }

    // Remember: we need to override equals and hashcode method in Entity class, otherwise will get null
    @Test
    public void addUserTest() {
        UserDto userDto = new UserDto();
        User user = new User("123","ABC");
        userDto.setUserId(user.getUserId());
        userDto.setUserName(user.getUserName());
        Mockito.when(converterService.convertToEntity(userDto)).thenReturn(user);
        Mockito.when(userRepository.save(user)).thenReturn(user);
        // we are checking equality of above user and after calling userService.addUser() method
        Assert.assertEquals(user, userService.addUser(userDto));
        Assert.assertEquals(Objects.equals(user,userService.addUser(userDto)),true);
        Assert.assertNotNull(userService.addUser(userDto));

    }

    @Test
    public void updateUserTest(){
        String id = "111";
        // userDto: provide updated name to userdto
        UserDto userDto = new UserDto();
        userDto.setUserId("111");
        userDto.setUserName("updated-user-name");
        // below is existing user
        User user = new User("111","First Demo");
        Mockito.when(converterService.convertToEntity(userDto)).thenReturn(new User());
        // below is mock existing user with existing name because we haven't set and saved yet.
        Mockito.when(userRepository.findByUserId(id)).thenReturn(user);
        // updated existing user with new userName
        user.setUserName(userDto.getUserName());
        // below will mock existing user with updated name because here we set and saved it
        Mockito.when(userRepository.save(user)).thenReturn(user);
        Assert.assertEquals(Objects.equals(user,userService.updateUser(userDto, id)),true);
        Assert.assertEquals("updated-user-name", userService.updateUser(userDto, id).getUserName());
        Assert.assertNotNull(userService.updateUser(userDto, id));
    }

   /* @Test
    public void deleteUserTest() {
        User user = new User(999, "Pranya", 33, "Pune");
        userService.deleteUser(user);
        verify(userRepository, times(1)).delete(user);
    }*/

}
