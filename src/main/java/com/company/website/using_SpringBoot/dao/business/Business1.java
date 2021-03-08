package com.company.website.using_SpringBoot.dao.business;

import com.company.website.using_SpringBoot.dao.data.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Business1 {

    @Autowired
    private Dao1 dao1;
    public String calculateSomething() {
        return dao1.retrieveSomething();

    }
    
}
