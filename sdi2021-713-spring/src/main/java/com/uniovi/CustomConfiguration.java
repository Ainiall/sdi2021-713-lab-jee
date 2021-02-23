package com.uniovi;

import java.util.Locale;

import org.springframework.context.annotation.*;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class CustomConfiguration implements WebMvcConfigurer {
    @Bean
    public LocaleResolver localeResolver() {
	// detecta la localizacion 
	SessionLocaleResolver localeResolver = new SessionLocaleResolver();
	localeResolver.setDefaultLocale(new Locale("es", "ES"));
	return localeResolver;
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
	// detecta el parametro de idioma y nos permite utilizarlo
	LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
	localeChangeInterceptor.setParamName("lang");
	return localeChangeInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
	registry.addInterceptor(localeChangeInterceptor());
    }
}
