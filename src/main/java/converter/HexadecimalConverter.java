package converter;

import static org.aspectj.runtime.internal.Conversions.intValue;

public class HexadecimalConverter {
    public String convertToHexadecimal(long decimal) {
        HexadecimalNumbers hexadecimalNumbers = new HexadecimalNumbers();
        long rest;
        String hexNumber = "";
        while (decimal > 0) {
            rest = decimal % 16;
            hexNumber = hexadecimalNumbers.getNumber(intValue(rest)) + hexNumber;
            decimal = decimal / 16;
        }
        return hexNumber;
    }
}
