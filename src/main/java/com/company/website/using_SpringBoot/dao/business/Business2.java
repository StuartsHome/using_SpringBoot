package com.company.website.using_SpringBoot.dao.business;
import com.company.website.using_SpringBoot.dao.data.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Business2 {

    @Autowired
    private Dao1 dao2;
    public String calculateSomething() {
        return dao2.retrieveSomething();

    }
    
}
