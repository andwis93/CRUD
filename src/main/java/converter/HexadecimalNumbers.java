package converter;

import java.util.HashMap;

public class HexadecimalNumbers {
    HashMap<Integer,String> hexadecimal = new HashMap<>();

    private void createList() {
        hexadecimal.put(0,"0");
        hexadecimal.put(1,"1");
        hexadecimal.put(2,"2");
        hexadecimal.put(3,"3");
        hexadecimal.put(4,"4");
        hexadecimal.put(5,"5");
        hexadecimal.put(6,"6");
        hexadecimal.put(7,"7");
        hexadecimal.put(8,"8");
        hexadecimal.put(9,"9");
        hexadecimal.put(10,"A");
        hexadecimal.put(11,"B");
        hexadecimal.put(12,"C");
        hexadecimal.put(13,"D");
        hexadecimal.put(14,"E");
        hexadecimal.put(15,"F");
    }

    public String getNumber(int decimalNumber) {
        createList();
        return hexadecimal.get(decimalNumber);
    }
}
