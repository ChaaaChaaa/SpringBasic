package com.springproject.basic.web;

import com.springproject.basic.common.MyLogger;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LogDemoService {
    private final MyLogger myLogger;
    public void logic(String id){
        //MyLogger myLogger = myLoggerObjectProvider.getObject();
        myLogger.log("service id = "+id);
    }
}
