import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @ClassName NotClass
 * @Description: TODO
 * @Author wanglonglong
 * @Date 2021/2/9
 * @Version V1.0
 **/
public class NotClass {
    String PATH = "D:\\idea-projects\\lianxi\\PoiAndEaseExcle";
    //不同类型的读取。
    public static void main(String[] args) {

    }
    @Test
    public void notType() throws IOException {
        //获取文件流
        FileInputStream fileInputStream = new FileInputStream(PATH + "//07货架.xlsx");
        //创建一个工作簿
        Workbook workbook = new XSSFWorkbook(fileInputStream);

        Sheet sheetAt = workbook.getSheetAt(0);
        //获取标题内容
        Row rowTitle = sheetAt.getRow(0);
        if (rowTitle!=null){
            int cellCount = rowTitle.getPhysicalNumberOfCells();
            for (int cellNum = 0;cellNum<cellCount;cellNum++){
                Cell cell = rowTitle.getCell(cellNum);
                if (cell!=null){
                    String stringCellValue = cell.getStringCellValue();
                    System.out.print(stringCellValue + "|");
                }
            }
            System.out.println();
        }
        //获取表中的内容
        int rowCount = sheetAt.getPhysicalNumberOfRows();
        for (int rowNum = 1; rowNum<rowCount;rowNum++){
            Row rowData = sheetAt.getRow(rowNum);
            if (rowData != null){
                //读取列
                int cellCount = rowTitle.getPhysicalNumberOfCells();
                for (int cellNum=0;cellNum<cellCount;cellNum++){
                    System.out.print("["+(rowNum+1)+"-"+(cellNum+1) + "]");
                }
            }
        }
    }
}
