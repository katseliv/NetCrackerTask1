package validators.impl;

import entities.Contract;
import validators.IValidator;
import validators.ValidationMessage;

public class ErrorValidator implements IValidator {

    @Override
    public ValidationMessage validate(Contract contract) {
        return null;
    }

}
