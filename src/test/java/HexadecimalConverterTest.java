import converter.HexadecimalConverter;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HexadecimalConverterTest {

    @Test
    void testHexadecimalConverter(){
        //Given
        HexadecimalConverter hexadecimalConverter = new HexadecimalConverter();

        //When
        String hexadecimal = hexadecimalConverter.convertToHexadecimal(1548689874648631287L);

        //Then
        assertEquals("157E0D3C55AD07F7", hexadecimal);
    }
}
