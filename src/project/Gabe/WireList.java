package project.Gabe;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The list of all the menu data to a wire tree making hobby.
 * 
 * 
 * @author Gabriel Ulrich
 */
public class WireList {

    private final String fileName = "wiredata.txt";
    List<Wire> myList;

    public WireList() {
        myList = new ArrayList();
//        try {
//            Files.createFile(Paths.get(fileName));
//        } catch (FileAlreadyExistsException fae) {
//            ;
//        } catch (IOException ex) {
//            Logger.getLogger(WireList.class.getName()).log(Level.SEVERE, null, ex);
//        }
        readList();
    }
//=====================================================C-R-U-D===================================
    public void create(Wire wire) {
        myList.add(wire);
//        writeList();
    }
    
    public Wire retrieve(int id) {
//    return a single wire record from the list or null if it doesn't exist
        for (Wire w : myList) {
            if (w.getId() == id) {
                return w;
            }
        }
        return null;
    }
    
    public void update(Wire wire) {
//      Updates all fields
        for (Wire w : myList) {
            if (w.getId() == wire.getId()) {
                w.setId(wire.getId());
                break;
            }
                if (w.getId() == wire.getId()) {
                w.setTimeWorked(wire.getTimeWorked());               
                break;
            }
            if (w.getId() == wire.getId()) {
                w.setToolTypes(wire.getToolTypes());               
                break;
            }
            if (w.getId() == wire.getId()) {
                w.setWireTypes(wire.getWireTypes());                
                break;
            }
            if (w.getId() == wire.getId()) {
                w.setPrice(wire.getPrice());
                break;
            }
        }
    }    
    
    public void delete(int id) {
        Wire myWire = null;
        for (Wire w : myList) {
            if (w.getId() == id) {
                myWire = w;
                break;
            }
            myList.remove(w);
            writeList();
        }
    }
//=====================================================ORDERBY===================================
    public String oderById() {
        //hw 12/5/16 pet is the name of the class, and then say what u need to sort by, so pet::getId
        myList.sort(Comparator.comparing(Wire::getId));
        return this.toString();
    }
    public String oderByWireTypes() {
        myList.sort(Comparator.comparing(Wire::getWireTypes));
        return this.toString();
    }
    public String oderByToolypes() {
        myList.sort(Comparator.comparing(Wire::getToolTypes));
        return this.toString();
    }
    public String oderByTimeWorked() {
        myList.sort(Comparator.comparing(Wire::getTimeWorked));
        return this.toString();
    }
    public String oderByPrice() {
        myList.sort(Comparator.comparing(Wire::getPrice).reversed());
        return this.toString();
    }
    public String oderByPrice2() {
        myList.sort((Wire w1, Wire w2) -> {
           if(w1.getWireTypes().equals(w2.getWireTypes())) {
               return Double.compare(w2.getPrice(), w1.getPrice());
           } else {
               return w1.getWireTypes().compareTo(w2.getWireTypes());
           }
        });
        return this.toString();
    }
    public String oderByTimeWorkedPrice() {
        myList.sort(Comparator.comparing(Wire::getTimeWorked).thenComparing(Wire::getPrice).reversed());
        return this.toString();
    }
//=====================================================STATISTICS===================================
    
    public String priceStatistics() {
        double standardDeviation = 0;
        double averagePrice = 0;
        double sumPrice = 0;
        int count = 0;
        double largestPrice = Integer.MIN_VALUE;
        double smallestPrice = Integer.MAX_VALUE;
        double total = 0;

        for (Wire wire : myList) {
            sumPrice += wire.getPrice();
            count++;
        }

        for (Wire wire : myList) {
            if (wire.getPrice() > largestPrice) {
                largestPrice = wire.getPrice();
            } else if (wire.getPrice() < smallestPrice) {
                smallestPrice = wire.getPrice();
            }
        }
        averagePrice = sumPrice / count;
        for (Wire wire : myList) {
            total += Math.pow((wire.price - averagePrice), 2);
        }
        if (total > 0) {
            standardDeviation = Math.sqrt(total / (count - 1));
        }

        return String.format("%10.2f  %20.2f  %20.2f  %20.2fm %20.2f", sumPrice, averagePrice, smallestPrice, largestPrice, standardDeviation);
}
//==================================================================================================
    private void readList() {
        Path path = Paths.get(fileName);
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String wireTypes = data[1];
                String toolTypes = data[2];
                double timeWorked = Double.parseDouble(data[3]);
                double price = Double.parseDouble(data[4]);
                Wire mywire = new Wire(id, wireTypes, toolTypes, timeWorked, price);
                myList.add(mywire);
            }
        } catch (IOException ex) {
            Logger.getLogger(WireList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void writeList() {
        Path path = Paths.get(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            for (Wire wire : myList) {
                writer.write(String.format("%d,%s,%.2f\n",
                        wire.getId(),
                        wire.getWireTypes(),
                        wire.getToolTypes(),
                        wire.getTimeWorked(),
                        wire.getPrice()));
            }
        } catch (IOException ex) {
            Logger.getLogger(WireList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Wire wire : myList) {
            sb.append(wire).append("\n");
        }
        return sb.toString();
        //return myList.toString();
    }
}

