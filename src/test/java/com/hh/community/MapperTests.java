package com.hh.community;
import com.hh.community.dao.DiscussPostMapper;
import com.hh.community.dao.UserMapper;
import com.hh.community.entity.DiscussPost;
import com.hh.community.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MapperTests {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private DiscussPostMapper discussPostMapper;
    @Test
    public void testSelectUser(){
        User user=userMapper.selectById(11);
        System.out.println(user);
        user=userMapper.selectByName("huanghao");
        System.out.println(user);
    }
    @Test
    public void testUpdateUser(){
        int rows=userMapper.updateStatus(11,0);
        System.out.println(rows);
        System.out.println(userMapper.selectById(11));
    }
    @Test
    public void testSelectDiscussPost(){
        List<DiscussPost> list=discussPostMapper.selectDiscussPosts(153,0,10);
        for (DiscussPost post : list) {
            System.out.println(post);
        }
    }
}
