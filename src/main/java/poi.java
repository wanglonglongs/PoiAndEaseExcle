import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.util.Date;

/**
 * @ClassName poi
 * @Description: TODO
 * @Author wanglonglong
 * @Date 2021/2/7
 * @Version V1.0
 **/
public class poi {
    String PATH = "D:\\idea-projects\\lianxi\\PoiAndEaseExcle";
    @Test
    public void poi07 () throws Exception {


        //创建工作簿 03 07 XSSFWorkbook()使用的对象不一样
        Workbook workbook = new XSSFWorkbook();
        //创建工作页
        Sheet sheet = workbook.createSheet("第一张表(名字)");
        //创建row
        Row row = sheet.createRow(0);
        //第一行
        //创建一个单元格
        Cell cell = row.createCell(0);
        //赋值单元格
        cell.setCellValue("poi写入字符串到Excel");
        //第二行
        Row row1 = sheet.createRow(1);
        Cell cell1 = row1.createCell(0);
        Date date = new Date();
        cell1.setCellValue(date);
        //生成一张表03 xls 07 xlsx后缀
        FileOutputStream fileOutputStream = new FileOutputStream(PATH + "//poi.xlsx");

        //写入
        workbook.write(fileOutputStream);
        //关闭流
        fileOutputStream.close();
        System.out.println("文件生成完毕");
    }

    @Test
    public void poi03() throws Exception {
        //创建工作簿
        Workbook workbook = new HSSFWorkbook();
        //工作页
        Sheet sheet = workbook.createSheet("03版本的写入");
        //创建行
        Row row = sheet.createRow(0);
        //单元格
        Cell cell = row.createCell(0);
        //赋值
        cell.setCellValue("03版本写入");
        //第一行第二列单元格
        Row row1 = sheet.createRow(1);
        Cell cell1 = row1.createCell(0);
        cell1.setCellValue(new Date());
        //文件上传路径
        FileOutputStream fileOutputStream = new FileOutputStream(PATH + "//03版本excel.xls");
        //写入
        workbook.write(fileOutputStream);

        //关闭流
        fileOutputStream.close();
        //输出
        System.out.println("03版本写入excel,yes");
    }
}
