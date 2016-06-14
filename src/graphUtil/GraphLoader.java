package graphUtil;

import jdk.internal.dynalink.support.ClassMap;
import nodes.ClassObject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;

/**
 * Created by Manu on 6/13/2016.
 */
public class GraphLoader {

    public void loadDependencyFile(String fileName) {
        Collection<ClassObject> nodes = new HashSet<ClassObject>();
        readAndCreateClassObject(fileName);
    }

    private void readAndCreateClassObject(String fileName) {
        BufferedReader reader = null;
        //try to read file
        try {
            String nextLine;
            reader = new BufferedReader(new FileReader(fileName));
            while ((nextLine = reader.readLine()) != null) {
                System.out.println("" + nextLine);
            }
            reader.close();

        } catch (FileNotFoundException e) {
            System.err.println("File Not found : " + fileName);
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Problem loading dependency file: " + fileName);
            e.printStackTrace();
        }
    }
}


