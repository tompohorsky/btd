package cz.tjhp.btd.source;

import cz.tjhp.btd.model.DonaldTrump;
import cz.tjhp.btd.util.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;


/**
 * Class for retrieving raw data from external source
 * @author Tomas Pohorsky
 * @since 2.4 2022
 * @version 1.0.0
 */
@Slf4j
@Component
public class DataPicker {
    private final RestTemplate restTemplate = new RestTemplate();

    /**
     * Method will get some random interesting facts about Chuck Norris
     * @return Raw data from external source (ResponseEntity)
     * @throws URISyntaxException If URI cannot be created.
     */
    public ResponseEntity<String> getSomethingFromChuck() throws URISyntaxException {
        URI uri = new URI(Constants.CHUCK_NORRIS_URL);
        log.debug("URI is valid");
        return restTemplate.getForEntity(uri, String.class);
    }

    /**
     * Method will get some shit from Donald Trump
     * @return Raw data from external source (ResponseEntity)
     * @throws URISyntaxException If URI cannot be created.
     */
    public ResponseEntity<DonaldTrump> getSomeShitFromDonald() throws URISyntaxException {
        URI uri = new URI(Constants.TRONALD_DUMP_URL);
        log.debug("URI is valid");
        return restTemplate.getForEntity(uri, DonaldTrump.class);
    }

}
