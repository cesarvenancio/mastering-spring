package com.mastering.spring.boot.assync.controller;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

@Controller
public class ResponseBodyEmitterController {

    private ExecutorService executor = Executors.newCachedThreadPool();
    
    @GetMapping("/rbe")
    public ResponseEntity<ResponseBodyEmitter> handleRbe(){
        ResponseBodyEmitter emitter = new ResponseBodyEmitter();
        
        executor.execute(() -> {
            try {
                emitter.send("/rbe@ "+ new Date(), MediaType.TEXT_PLAIN);
                emitter.complete();
            }catch (Exception e) {
                emitter.completeWithError(e);
            }
        });
        
        return new ResponseEntity<>(emitter, HttpStatus.OK);
    }
}
