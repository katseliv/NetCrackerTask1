package validators.impl;

import entities.Contract;
import entities.Person;
import enums.Status;
import validators.IValidator;
import validators.ValidationMessage;

/**
 * Class validators.PersonValidator
 * @author Ekaterina Selivanova
 **/
public class PersonValidator implements IValidator {
    @Override
    public ValidationMessage validate(Contract contract) {
        Person owner = contract.getOwner();

        if (owner.getAge() >= 18) {
            return new ValidationMessage(Status.OK, "Contract's owner is an adult");
        }
        return new ValidationMessage(Status.RED_RISK, "Contract's owner is a child");
    }
}
