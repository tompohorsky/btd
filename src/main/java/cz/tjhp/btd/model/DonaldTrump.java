package cz.tjhp.btd.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.Instant;

/**
 * Model class represent speech of Donald Trump
 * @author Tomas Pohorsky
 * @since 2.4 2022
 * @version 1.0.0
 */
@Slf4j
@Getter
@NoArgsConstructor
public class DonaldTrump {
    private Instant appeared_at;
    private String value;
}
