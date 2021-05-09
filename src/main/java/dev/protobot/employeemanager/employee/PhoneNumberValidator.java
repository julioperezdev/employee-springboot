package dev.protobot.employeemanager.employee;

import java.util.function.Predicate;

public class PhoneNumberValidator implements Predicate<String> {

    @Override
    public boolean test(String phoneNumber) {
        if(phoneNumber.startsWith("+54911") && phoneNumber.length() == 14)
            return true;
        return false;
    }
}
