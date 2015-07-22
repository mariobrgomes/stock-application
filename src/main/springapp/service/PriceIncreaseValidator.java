package service;

import lombok.Data;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by 964456 on 13/07/2015.
 */

@Data
public class PriceIncreaseValidator implements Validator {

    private static int DEFAULT_MIN_PERCENTAGE = 0;
    private static int DEFAULT_MAX_PERCENTAGE = 50;

    private int minPercentage = DEFAULT_MIN_PERCENTAGE;
    private int maxPercentage = DEFAULT_MAX_PERCENTAGE;

    protected final Log logger = LogFactory.getLog(getClass());

    public boolean supports(Class clazz) {
        return PriceIncrease.class.equals(clazz);
    }

    public void validate(Object obj, Errors errors) {
        PriceIncrease priceIncrease = (PriceIncrease) obj;

        if (priceIncrease.getPercentage() > maxPercentage) {
            errors.rejectValue("percentage", "error.too-high",
                    new Object[] {new Integer(maxPercentage)}, "Value too high.");
        }
        if (priceIncrease.getPercentage() <= minPercentage) {
            errors.rejectValue("percentage", "error.too-low",
                    new Object[] {new Integer(minPercentage)}, "Value too low.");
        }
        }
    }
