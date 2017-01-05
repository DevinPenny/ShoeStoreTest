/**
 * Created by Devin Penny on 1/4/17.
 */
package TestDataManagement;

import java.util.HashMap;
import java.util.ArrayList;
import com.codoid.products.fillo.*;

public class ExcelDataManager {

    public String FilePath = "./src/test/java/TestDataManagement/ExcelData/TestExecutionList.log";

    public HashMap<Integer,HashMap<String,String>> queryExcel (String sheetName, String query) {

        int y = 0;

        HashMap<Integer,HashMap<String,String>> hmap = new HashMap<Integer,HashMap<String,String>>();
        try {

            Fillo fillo=new Fillo();
            Connection connection = fillo.getConnection(sheetName);

            Recordset recordset=connection.executeQuery(query);

            while (recordset.next()) {
                HashMap<String,String> value = new HashMap<String,String>();
                ArrayList<String> dataColl=recordset.getFieldNames();

                for(int x = 0; x < dataColl.size();x++) {
                    String testData=dataColl.get(x);
                    //System.out.println(testData);
                    //System.out.println(recordset.getField(testData));
                    value.put(testData, recordset.getField(testData));
                }

                hmap.put(y, value);
                y ++;
            }

            recordset.close();
            connection.close();
        } catch( Exception e ) {
            e.printStackTrace();
            System.out.println("Excel db error");
            return null;
        }
        return hmap;
    }

}



