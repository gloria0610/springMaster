import com.homework.domain.UserDO;
import com.homework.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by jiangyayi on 15/12/9.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})

public class TestUserService {
    @Autowired
    private UserService userService;
    @Test
    public void hasMatchUser(){
        boolean b1=userService.hasMatchUser("admin","123456");
        boolean b2=userService.hasMatchUser("admin","1111");
        assertTrue(b1);
        assertFalse(b2);
    }

    @Test
    public void findUserByUserName(){
        UserDO userDO=userService.findUserByUserName("admin");
        assertEquals(userDO.getUserName(),"admin");
    }

//    @Test
//    public void getUserByUserName(){
//        UserDO userDO=userService.getUserByUserName("admin");
//        assertEquals(userDO.getUserName(),"admin");
//    }
}
