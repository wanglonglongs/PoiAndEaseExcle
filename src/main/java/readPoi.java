import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;

/**
 * @ClassName readPoi
 * @Description: TODO
 * @Author wanglonglong
 * @Date 2021/2/9
 * @Version V1.0
 **/
public class readPoi {
    String PATH = "D:\\idea-projects\\lianxi\\PoiAndEaseExcle";
    //读取03版
    @Test
    public void read03() throws Exception {


        //获取文件流
        FileInputStream fileInputStream = new FileInputStream(PATH + "//03版本excel.xls");

        //创建一个工作簿。使用excel能操作的功能这里都有
        Workbook workbook = new HSSFWorkbook(fileInputStream);

        //获取表（得到表）
        Sheet sheet = workbook.getSheetAt(0);
        //行得到行）
        Row row = sheet.getRow(0);
        //列》= row.getCell(0);
        //注意获取不同类型的值
        Cell cell = row.getCell(0);

        System.out.println(cell.getStringCellValue());
        //关闭流
        fileInputStream.close();
    }
    //读取07版
    @Test
    public void read07() throws Exception {
        //获取流
        FileInputStream fileInputStream = new FileInputStream(PATH + "//poi.xlsx");
        //工作簿
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        //查找页
        Sheet sheetAt = workbook.getSheetAt(0);
        //查找行
        Row row = sheetAt.getRow(1);
        //查找列
        Cell cell = row.getCell(0);
        //类型为DATE
        System.out.println(cell.getDateCellValue());

        //关闭流
        fileInputStream.close();
    }
    //大数据量读取
    @Test
    public void bigread() throws Exception {
        //读取流
        FileInputStream fileInputStream = new FileInputStream(PATH + "//07bigwirte.xlsx");
        //工作簿
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        //查找页
        Sheet sheetAt = workbook.getSheetAt(0);
        //遍历循环数据
        for (int rowNum=0;rowNum<10000;rowNum++){
            Row row = sheetAt.getRow(rowNum);
            for (int cellNum=0;cellNum<10;cellNum++){
                Cell cell = row.getCell(cellNum);
                double numericCellValue = cell.getNumericCellValue();
                System.out.println(numericCellValue);
            }
        }
        //关闭流
        fileInputStream.close();
    }

}
