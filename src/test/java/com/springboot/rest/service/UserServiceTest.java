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

    @Test
    public void testForupdateExistingUser() {
        String userId = "222";
        User user = new User();
        user.setUserId("222");
        user.setUserName("updated-user-name");
        Mockito.when(userRepository.findById(userId)).thenReturn(Optional.ofNullable(user));
        Mockito.when(userRepository.save(user)).thenReturn(user);
        Assert.assertNotNull(user);
        Assert.assertNotNull(user.getUserName());
    }

    @Test
    public void testForCreateNewUser() {
        String userId = "111";
        String userName = "First Demo";
        User user = new User();
        user.setUserId(userId);
        user.setUserName(userName);
        userRepository.saveAndFlush(user);
        Assert.assertEquals("111", userId);
    }
  /*  @Test
    public void addUserTest() {
        UserDto userDto = new UserDto();
        userDto.setUserId("123");
        userDto.setUserName("ABC");
        User user = new User("123","ABC");
        Mockito.when(converterService.convertToEntity(userDto)).thenReturn(user);
        Mockito.when(userRepository.save(user)).thenReturn(user);
        Assert.assertEquals(Objects.equals(user,userService.addUser(userDto)),true);

    }*/

  /*  @Test
    public void addUserTest(){
        User user = new User(04, "Jom", 61, "PSA");
        Mockito.when(userRepository.save(user)).thenReturn(user);
        // we are checking equality of above user and after calling userService.addUser() method
        Assert.assertEquals(user, userService.addUser(user));
        Assert.assertNotNull(userService.addUser(user));
    }*/

   /* @Test
    public void deleteUserTest() {
        User user = new User(999, "Pranya", 33, "Pune");
        userService.deleteUser(user);
        verify(userRepository, times(1)).delete(user);
    }*/





}
