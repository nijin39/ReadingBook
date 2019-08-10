package com.tandem6.readingbook.common.config;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.tandem6.readingbook.book.application.BookApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {

    /**
     * This event is executed as late as conceivably possible to indicate that
     * the application is ready to service requests.
     */

    @Autowired
    private BookApplication bookApplication;

    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {
        try {
            seedData();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }

    private void seedData() throws IOException, UnirestException {
        bookApplication.findByIsbnAndSave("9771599406009");
        bookApplication.findByIsbnAndSave("9791156396604");
        bookApplication.findByIsbnAndSave("9791156391586");
    }

}