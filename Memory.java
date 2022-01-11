

import java.util.ArrayList;
import java.util.Collections;

public class Memory {
    private ArrayList<String> pm;  // Physical Memory
    private ArrayList<String> vm;  // Virtual Memory
    private Integer idxPos = 0;

    public Memory(Integer memLength) {
        this.pm = new ArrayList<>(Collections.nCopies(memLength, ""));
        this.vm = new ArrayList<>(Collections.nCopies(2 * memLength, ""));
    }

    static boolean checkOperation(String valueOp) {
        return valueOp.equals("R") == true ? true : false;
    }

    public void read(Integer position) {
        if (vm.get(position).isEmpty()) {
            System.out.println("- Não há nada armazenado na paginação da memória virtual.");
        } else {
            System.out.println("- O valor armazendo na paginação [" +  vm.get(position)
                    +  "] da memória física é " + pm.get(Integer.parseInt(vm.get(position))) + ".");
        }
    }

    public void write(Integer position, String value) {
        //mapping physical memory
        if (idxPos == pm.size()) {
            idxPos = 0;
        }

        if (vm.get(position).isEmpty()) {
            pm.set(idxPos, value);
            vm.set(position, idxPos.toString());

            System.out.println("- O valor " + value + " foi armazendo na paginação ["+ idxPos + "] da memória física atráves da paginação [" + position + "] da memória virtual.");

            idxPos += 1;
        } else {
            pm.set(Integer.parseInt(vm.get(position)), value);
            System.out.println("- O valor armazenado é " + value + ".");
        }
    }
}
