import converter.HexadecimalConverter;
import org.junit.jupiter.api.Test;

public class HexadecimalConverterTest {

    @Test
    void testHexadecimalConverter(){
        HexadecimalConverter hexadecimalConverter = new HexadecimalConverter();
        System.out.println(hexadecimalConverter.convertToHexadecimal(1548689874648631287L));
    }
}
