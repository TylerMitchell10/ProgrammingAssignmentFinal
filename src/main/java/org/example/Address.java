package org.example;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@Getter
@Setter
public class Address {
    private int streetNo;
    private String street;
    private String city;
    private String province;
    private String postalCode;
    private String country;

    public Address(int streetNo, String street, String city, String province, String country, String postalCode) {
        this.streetNo = streetNo;
        this.street = street;
        this.city = city;
        this.province = province;
        this.country = country;
        this.postalCode = isPostalCodeValid(postalCode) ? postalCode : null;
    }
    public static boolean isPostalCodeValid(String postalCode) {
        if (postalCode == null) {
            System.out.println("Postal code is null");
            return false;
        }
        if (postalCode.length() == 6) {
            return Character.isAlphabetic(postalCode.charAt(0)) &&
                    Character.isDigit(postalCode.charAt(1)) &&
                    Character.isAlphabetic(postalCode.charAt(2)) &&
                    Character.isDigit(postalCode.charAt(3)) &&
                    Character.isAlphabetic(postalCode.charAt(4)) &&
                    Character.isDigit(postalCode.charAt(5));
        }
        if (postalCode.length() == 7) {
            return Character.isAlphabetic(postalCode.charAt(0)) &&
                    Character.isDigit(postalCode.charAt(1)) &&
                    Character.isAlphabetic(postalCode.charAt(2)) &&
                    Character.isWhitespace(postalCode.charAt(3)) &&
                    Character.isDigit(postalCode.charAt(4)) &&
                    Character.isAlphabetic(postalCode.charAt(5)) &&
                    Character.isDigit(postalCode.charAt(6));
        }
        return false;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = isPostalCodeValid(postalCode) ? postalCode : null;
    }
}
