package com.zipcodewilmington.phone;

import com.zipcodewilmington.exceptions.InvalidPhoneNumberFormatException;
import com.zipcodewilmington.tools.RandomNumberFactory;

import java.util.Random;
import java.util.logging.Logger;

/**
 * Created by leon on 5/1/17.
 */
public final class PhoneNumberFactory {
    private static final Logger logger = Logger.getGlobal();

    private PhoneNumberFactory() {
        /** This constructor is private
         *  This class is uninstantiable */
    }

    /**
     * @param phoneNumberCount - number of PhoneNumber objects to instantiate
     * @return array of randomly generated PhoneNumber objects
     */ //TODO - Implement logic
    public static PhoneNumber[] createRandomPhoneNumberArray(int phoneNumberCount) {

        PhoneNumber[] arrayOfNumbers = new PhoneNumber[phoneNumberCount];


        for (int i = 0; i < phoneNumberCount; i++){
           arrayOfNumbers[i] = createRandomPhoneNumber();
        }


        return arrayOfNumbers;
    }

    /**
     * @return an instance of PhoneNumber with randomly generated phone number value
     */ //TODO - Implement logic
    public static PhoneNumber createRandomPhoneNumber() {
        int areaCode = RandomNumberFactory.createInteger(100,999);
        int centralOfficeCode = RandomNumberFactory.createInteger(100,999);
        int phoneLineCode = RandomNumberFactory.createInteger(1000,9999);

        return createPhoneNumberSafely(areaCode, centralOfficeCode, phoneLineCode);

    }



    /*
    Using the createPhoneNumber method from Part 1, define the createPhoneNumberSafely method such that the input parameters,
    areaCode, centralOfficeCode, phoneLineCode are concatenated to create a String representation of the respective phone number.

Use this String object to construct a new instance of PhoneNumber and return it.

If the concatentation of the input parameters yields a String whose value does not match the format (###)-###-####, then our PhoneNumber will throw a InvalidPhoneNumberFormatException.
If a InvalidPhoneNumberFormatException is thrown within this method, catch it and return null.
     */
    /**
     * @param areaCode          - 3 digit code
     * @param centralOfficeCode - 3 digit code
     * @param phoneLineCode     - 4 digit code
     * @return a new phone number object
     */ //TODO - if input is valid, return respective PhoneNumber object, else return null
    public static PhoneNumber createPhoneNumberSafely(int areaCode, int centralOfficeCode, int phoneLineCode) {
String createNum = String.format("(%d)-%d-%d", areaCode, centralOfficeCode, phoneLineCode);

     try{

         return createPhoneNumber(createNum);
     }
     catch (InvalidPhoneNumberFormatException exception){
         logger.info(createNum + " is not a valid phone number");
         exception.printStackTrace();
         return null;
     }



    }

    /**
     * @param phoneNumberString - some String corresponding to a phone number whose format is `(###)-###-####`
     * @return a new phone number object
     * @throws InvalidPhoneNumberFormatException - thrown if phoneNumberString does not match acceptable format
     */ // TODO - Add throws statement to method signature
    public static PhoneNumber createPhoneNumber(String phoneNumberString) throws InvalidPhoneNumberFormatException {
        PhoneNumber phoneNumber = new PhoneNumber(phoneNumberString);
        logger.info("Attempting to create a new PhoneNumber object with a value of " + phoneNumberString);
        return phoneNumber;
}
}
/*
Upon instantiating a new PhoneNumber object,
it is possible to receive a InvalidPhoneNumberFormatException if the String passed into the PhoneNumber constructor does not fit the format (###)-###-####.


InvalidPhoneNumberFormatException extends IOException, which is a checked exception.
Modify the createPhoneNumber method so that it throws any resulting InvalidPhoneNumberFormatException.
This will ensure that any method calling createPhoneNumber will have to handle the exception.
 */


