package com.hh.community.service;

import com.hh.community.dao.AlphaDao;
import com.hh.community.dao.AlphaDaoHibernateImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlphaService {
    @Autowired
    private AlphaDaoHibernateImpl alphaDaoHibernate;
    public String find(){
        return alphaDaoHibernate.select();
    }

}
