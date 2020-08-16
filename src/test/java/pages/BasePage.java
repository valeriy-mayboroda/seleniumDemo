package pages;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BasePage {
    @Getter
    private final Logger logger = LoggerFactory.getLogger(getClass().getSimpleName());
}