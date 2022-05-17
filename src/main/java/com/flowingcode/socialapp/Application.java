package com.flowingcode.socialapp;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import com.flowingcode.addons.applayout.MenuItem;
import com.flowingcode.addons.applayout.endpoint.MenuItemsProvider;
import com.flowingcode.addons.applayout.listener.RegisterEndpointServiceInitListener;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.theme.Theme;

/**
 * The entry point of the Spring Boot application.
 *
 * Use the @PWA annotation make the application installable on phones, tablets
 * and some desktop browsers.
 *
 */
@SpringBootApplication
@Theme(value = "socialapp")
@PWA(name = "Social App", shortName = "Social App", offlineResources = {})
@NpmPackage(value = "@adobe/lit-mobx", version = "2.0.0")
@NpmPackage(value = "mobx", version = "^6.3.5")
@NpmPackage(value = "line-awesome", version = "1.3.0")
public class Application extends SpringBootServletInitializer implements AppShellConfigurator {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public MenuItemsProvider createMenuItems() {
        return () -> Arrays.asList(
            new MenuItem("Forum").setHref("forum"),
            new MenuItem("Administration").add(
                new MenuItem("Contacts").setHref("contacts")),
            new MenuItem("About").setHref("about"));
    }

}
