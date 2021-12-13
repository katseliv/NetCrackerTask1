package validators.impl;

import entities.Contract;
import enums.Status;
import validators.IValidator;
import validators.ValidationMessage;

/**
 * Class validators.DateValidator
 * @author Ekaterina Selivanova
 **/
public class DateValidator implements IValidator {

    @Override
    public ValidationMessage validate(Contract contract) {
        if (contract.getStartDate().isBefore(contract.getEndDate())) {
            return new ValidationMessage(Status.OK, "Contract's date is valid");
        }
        return new ValidationMessage(Status.RED_RISK, "Contract's start date is later than contract's end date");
    }

}
