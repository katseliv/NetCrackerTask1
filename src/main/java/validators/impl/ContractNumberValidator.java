package validators.impl;

import entities.Contract;
import enums.Status;
import validators.IValidator;
import validators.ValidationMessage;

/**
 * Class validators.ContractNumberValidator
 * @author Ekaterina Selivanova
 **/
public class ContractNumberValidator implements IValidator {
    @Override
    public ValidationMessage validate(Contract contract) {
        if (contract.getContractNumber() > 0) {
            return new ValidationMessage(Status.OK, "Contract number is valid");
        }
        return new ValidationMessage(Status.ERROR, "Contract number isn't valid");
    }
}
