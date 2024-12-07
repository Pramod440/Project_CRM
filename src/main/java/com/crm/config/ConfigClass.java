package com.crm.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigClass {
    /* configuration classes are special classes that are used to configure beans,when start the project coonfiguration
        classes automatically execute and loads all the beans into spring IOC container */


    @Bean
    public ModelMapper getMapper() {  /*ModelMapper is an external class so that it's object can't be created by spring IOC so that we
		                                     are Creating this getModelMapper() method it will create a object(bean) for the ModelMapper class
		                                        and store the object details into spring IOC */
        return new ModelMapper();

		/* ModelMapper is a Java library that helps in mapping objects from one model to another(we are copying all details from mapToEntity class
		   to mapToDto nd vice versa by using ModelMapper class), to reducing the need for manual mapping code. */
    }

}

