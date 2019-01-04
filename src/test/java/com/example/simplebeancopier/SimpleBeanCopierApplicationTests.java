package com.example.simplebeancopier;

import com.example.simplebeancopier.copier.BeanCopier;
import com.example.simplebeancopier.copier.SimpleBeanCopier;
import com.example.simplebeancopier.model.UserEntity;
import com.example.simplebeancopier.model.UserVO;
import javafx.scene.control.Alert;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SimpleBeanCopierApplicationTests {

    private static BeanCopier copyFromEntity = new SimpleBeanCopier(UserEntity.class, UserVO.class);

    @Test
    public void contextLoads() {
        UserEntity entity = new UserEntity();
        entity.setId(1L);
        entity.setLoginName("fei");
        entity.setName("飞");
        entity.setPassword("123456");
        entity.setPosition("111");
        UserVO userVO = (UserVO)copyFromEntity.copy(entity);
        System.out.println(userVO.toString());

        UserVO temp = null;
        Long begin = System.nanoTime();
        for(int i=0; i<=10000; i++){
            temp = (UserVO)copyFromEntity.copy(entity);
        }
        long end = System.nanoTime();
        System.out.println("SimpleBeanCopier多次耗时：" + String.valueOf(end - begin));
        begin = System.nanoTime();
        for(int i=0; i<=10000; i++){
            BeanUtils.copyProperties(entity, temp);
        }
        end = System.nanoTime();
        System.out.println("BeanUtils多次耗时：" + String.valueOf(end - begin));
        Assert.assertTrue(userVO != null);
    }

}

