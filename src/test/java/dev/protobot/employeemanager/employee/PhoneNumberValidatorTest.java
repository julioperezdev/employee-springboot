package dev.protobot.employeemanager.employee;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PhoneNumberValidatorTest {

    private PhoneNumberValidator underTest;

    @BeforeEach
    void setUp() {
        underTest = new PhoneNumberValidator();
    }

    @Test
    @DisplayName("Should pass when does start with +54 and have a length 14")
    void itShouldValidatePhoneNumberWhenDoesStartWithPlusSign() {
        //Given
        String phoneNumber = "+5491159230699";
        //When
        boolean idValid = underTest.test(phoneNumber);
        //Then
        assertThat(idValid).isTrue();
    }

    @Test
    @DisplayName("Should fail when does not start with +54")
    void itShouldValidatePhoneNumberWhenDoesNotStartWithPlusSign() {
        //Given
        String phoneNumber = "+5191159230699";
        //When
        boolean idValid = underTest.test(phoneNumber);
        //Then
        assertThat(idValid).isFalse();
    }

    @Test
    @DisplayName("Should fail when length is bigger than 14")
    void itShouldValidatePhoneNumberWhenIncorrectAndHasLengthBiggerThat14() {
        //Given
        String phoneNumber = "+54911592306999";
        //When
        boolean idValid = underTest.test(phoneNumber);
        //Then
        assertThat(idValid).isFalse();
    }

    @Test
    @DisplayName("Should fail when length is Smaller than 14")
    void itShouldValidatePhoneNumberWhenIncorrectAndHasLengthSmallerThat14() {
        //Given
        String phoneNumber = "+54911592306";
        //When
        boolean idValid = underTest.test(phoneNumber);
        //Then
        assertThat(idValid).isFalse();
    }


}
