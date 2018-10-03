package com.myFinance;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@SpringBootApplication
public class MainFinanceApplication {

    private static final Logger log = LoggerFactory.getLogger(MainFinanceApplication.class);

    /**
     * Get values from properties file.
     * */
    private static String profile;
    private static String serverPort;

    @Value("${spring.profiles.active}")
    public void setProfile(String profile) {
        try {
            log.info(">> Active Profile:           [" + profile + "]");
            MainFinanceApplication.profile = profile.replace("\"","").toUpperCase();
        }
        catch (Exception e){
            log.error("\nThere was an error: "+e+"\n");
        }
    }

    @Value("${server.port}")
    public void setServerPort(String serverPort) {
        try {
            log.info(">> Server Port:              [" + serverPort + "]");
            MainFinanceApplication.serverPort = serverPort.replace("\"","").toUpperCase();
        }
        catch (Exception e){
            log.error("\nThere was an error: "+e+"\n");
        }
    }

    /**
     * The Main method itself.
     * */
    public static void main(String[] args){
        SpringApplication.run(MainFinanceApplication.class, args);

        log.info("||////////////////////////////////////////////////////////////////////////////////////////||");
        log.info("||                                 Family Budget                                          ||");
        log.info("||                             Created by Zoltan Kiss                                     ||");
        log.info("||                                 Copyright 2018                                         ||");
        log.info("||////////////////////////////////////////////////////////////////////////////////////////||");
        log.info("******************* Family Budget Application Environment Variables *************************");
        log.info("Active Profile:           [" + profile + "]");
        log.info("Server Port:              [" + serverPort + "]");
        log.info(profile+"_DB_URL:          [" + System.getenv(profile+"_DB_URL") + "]");
        log.info(profile+"_DB_USER:         [" + System.getenv(profile+"_DB_USER") + "]");
        log.info(profile+"_DB_PASSWORD:     [" + System.getenv(profile+"_DB_PASSWORD") + "]");
        log.info(profile+"_EMAIL_ADDRESS:   [" + System.getenv(profile+"_EMAIL_ADDRESS") + "]");
        log.info(profile+"_EMAIL_PASSWORD:  [" + System.getenv(profile+"_EMAIL_PASSWORD") + "]");
        log.info("***********************************************************************************");
        log.info(">> [FinancApplication.main] - Starting Application ... Please Stand by...");

        try {
            String myUrl = "http://localhost:"+serverPort;
            openBrowser(myUrl);
        }
        catch (Exception e){
            log.error("\nThere was an error: "+e+"\n");
        }

    }

    /**
     *
     * */
    private static void openBrowser(String url) {
        log.info(">> [openBrowser.main] - Automatically open the app in a browser...");

        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.browse(new URI(url));
                log.info(">> [openBrowser.main] - Browser opened at: {}", url);
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
            }
        } else {
            Runtime runtime = Runtime.getRuntime();
            try {
                runtime.exec("rundll32 url.dll,FileProtocolHandler " + url);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

