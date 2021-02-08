import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
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
    //poi 基本写入
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
    //poi大量写入
    //03版 1.72秒
    @Test
    public void poi03bigwrite() throws Exception {
        //起始时间
        long begin = System.currentTimeMillis();

        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet("03版本大数据量写入");
        //当写入量大于65536时会报出异常(java.lang.IllegalArgumentException: Invalid row number (65536) outside allowable range (0..65535))(03版本只支持这么多行)
        for (int rowNum = 0;rowNum <65535;rowNum++){
            Row row = sheet.createRow(rowNum);
            for (int cellNum = 0;cellNum<11;cellNum++){
                row.createCell(cellNum).setCellValue(cellNum);

            }
        }
        System.out.println("执行over");
        //创建文件
        FileOutputStream fileOutputStream = new FileOutputStream(PATH + "//大数据写入.xls");
        //写入
        workbook.write(fileOutputStream);
        //关闭流
        fileOutputStream.close();
        //结束时间
        long end = System.currentTimeMillis();
        System.out.println((double) (end-begin)/1000);
    }
    //07版速度较慢耗时较长6.703 得知07版大量写入慢 优化，缓存(十万条数据时间13秒)
    @Test
    public void poi07bigwrite() throws Exception {
        long begin = System.currentTimeMillis();

        Workbook workbook = new XSSFWorkbook();

        Sheet sheet = workbook.createSheet("07版本大量写入数据");

        for (int rowNum=0;rowNum<100000;rowNum++){
            Row row = sheet.createRow(rowNum);
            for (int cellNum=0;cellNum<10;cellNum++){
                row.createCell(cellNum).setCellValue(cellNum);
            }
        }
        System.out.println("写入完毕");
        FileOutputStream fileOutputStream = new FileOutputStream(PATH + "//07bigwirte.xlsx");
        workbook.write(fileOutputStream);
        fileOutputStream.close();
        long end = System.currentTimeMillis();
        System.out.println((double) (end-begin)/1000);
    }
    //加速07版写入十万条数据时间（1.984）秒 注意产生的临时文件删除掉
    @Test
    public void poi07bigwriteS() throws Exception {
        long begin = System.currentTimeMillis();

        Workbook workbook = new SXSSFWorkbook();

        Sheet sheet = workbook.createSheet("07版本大量写入数据加速版");

        for (int rowNum=0;rowNum<100000;rowNum++){
            Row row = sheet.createRow(rowNum);
            for (int cellNum=0;cellNum<10;cellNum++){
                row.createCell(cellNum).setCellValue(cellNum);
            }
        }
        System.out.println("写入完毕");
        FileOutputStream fileOutputStream = new FileOutputStream(PATH + "//07bigwirteS.xlsx");
        workbook.write(fileOutputStream);
        //清除临时file
        ((SXSSFWorkbook) workbook).dispose();

        fileOutputStream.close();
        long end = System.currentTimeMillis();
        System.out.println((double) (end-begin)/1000);
    }
}
