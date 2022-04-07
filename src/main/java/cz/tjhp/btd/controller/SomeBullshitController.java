package cz.tjhp.btd.controller;

import cz.tjhp.btd.service.SomeBullshitService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;
import java.rmi.UnexpectedException;

/**
 * RestController for getting simple data from Chuck Norris API
 * @author Tomas Pohorsky
 * @since 2.4 2022
 * @version 1.0.0
 */
@Slf4j
@RestController
@AllArgsConstructor
public class SomeBullshitController {
    private SomeBullshitService someBullshitService;

    /**
     * Endpoint for getting some facts about Chuck Norris
     * @return Pure truth
     */
    @GetMapping("/chuck")
    public ResponseEntity<String> getChuckInfo(){
        log.info("GET /chuck");
        try {
            return ResponseEntity.ok(someBullshitService.getFactAboutChuck());
        } catch (URISyntaxException e) {
            log.error("Invalid URI!");
            return ResponseEntity.badRequest().build();
        } catch (UnexpectedException e) {
            log.warn("No response from Chuck API");
            return ResponseEntity.notFound().build();
        }
    }


    /**
     * Endpoint for getting some bullshits from Donald Trump
     * @return Deep shit
     */
    @GetMapping("/trump")
    public ResponseEntity<String> getDonaldsQuote(){
        log.info("GET /chuck");
        try {
            return ResponseEntity.ok(someBullshitService.getTrumpQuote());
        } catch (URISyntaxException e) {
            log.error("Invalid URI!");
            return ResponseEntity.badRequest().build();
        } catch (UnexpectedException e) {
            log.warn("No response from Chuck API");
            return ResponseEntity.notFound().build();
        }
    }

}
