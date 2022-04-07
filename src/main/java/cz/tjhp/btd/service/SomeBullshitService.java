package cz.tjhp.btd.service;

import cz.tjhp.btd.model.DonaldTrump;
import cz.tjhp.btd.source.DataPicker;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.net.URISyntaxException;
import java.rmi.UnexpectedException;

/**
 * Service for make correct response from DatePicker
 * @author Tomas Pohorsky
 * @since 2.4 2022
 * @version 1.0.0
 */
@Slf4j
@Service
@AllArgsConstructor
public class SomeBullshitService {
    private DataPicker dataPicker;

    /**
     * Method will prepare response (String) for FE needs
     * @return String value of Chuck Norris info
     * @throws URISyntaxException If URI cannot be created.
     * @throws UnexpectedException If no response comes from API
     */
    public String getFactAboutChuck() throws URISyntaxException, UnexpectedException {
        var response = dataPicker.getSomethingFromChuck();
        if(response == null)
            throw new UnexpectedException("No response from Chuck Norris API");
        log.debug("Response arrived");
        return response.getBody();
    }


    /**
     * Method will prepare response (String) for FE needs
     * @return String value of Donald Trump quote
     * @throws URISyntaxException If URI cannot be created.
     * @throws UnexpectedException If no response comes from API
     */
    public String getTrumpQuote() throws URISyntaxException, UnexpectedException {
        var response = dataPicker.getSomeShitFromDonald();
        if(response.getBody() == null)
            throw new UnexpectedException("No response from Tronald Dump API");
        log.debug("Response arrived");

        DonaldTrump donald = response.getBody();
        return donald.getValue() + "    (" + donald.getAppeared_at() + ")";
    }

}
