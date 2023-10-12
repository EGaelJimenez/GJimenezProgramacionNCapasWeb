package com.digis01.GJimenezProgramacionNCapasWeb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GJimenezProgramacionNCapasWebApplication implements CommandLineRunner{

    public static Logger LOG = LoggerFactory.getLogger(GJimenezProgramacionNCapasWebApplication.class);
    
    public static void main(String[] args) {
		SpringApplication.run(GJimenezProgramacionNCapasWebApplication.class, args);
	}
    
    @Override
    public void run (String...args)throws Exception{
        LOG.warn("Peligro");
    }

}

