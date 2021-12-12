package validators.impl;

import entities.Contract;
import validators.IValidator;
import validators.ValidationMessage;

public class DateValidator implements IValidator {

    @Override
    public ValidationMessage validate(Contract contract) {
        if (contract.getStartDate().isBefore(contract.getEndDate())) {
            return new ValidationMessage(200, "Contract's date is valid");
        }
        return new ValidationMessage(300, "Contract's date isn't valid");
    }

}
