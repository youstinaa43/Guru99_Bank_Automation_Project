import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelReader {
    static FileInputStream file=null;
    public FileInputStream getFileInput(){
        //String filePath=System.getProperty("user.dir")+"/resources/LoginTestData.xlsx";
        String filePath="F:\\Java\\Projects\\Guru99Banking\\src\\main\\resources\\LoginTestData.xlsx";
        File srcFile=new File(filePath);
        try {
            file=new FileInputStream(srcFile);

        } catch (FileNotFoundException e) {
            System.out.println("Test Data file not found");
            System.exit(0);
        }
        return file;
    }
    public Object[][] getExcelData() throws IOException {
        file=getFileInput();
        XSSFWorkbook workbook=new XSSFWorkbook(file);
        XSSFSheet sheet=workbook.getSheetAt(0);
        int totalRows=sheet.getLastRowNum();
        int totalColumns=5;
        String[][] arrayExcelData=new String[totalRows][totalColumns];
        for(int i=1;i<=totalRows;i++){
            for(int j=0;j<totalColumns;j++){
                XSSFRow row=sheet.getRow(i);
                arrayExcelData[i-1][j]=row.getCell(j).toString();
            }
        }
        workbook.close();
        return arrayExcelData;
    }
}
