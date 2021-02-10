import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;

/**
 * @ClassName MathClass
 * @Description: TODO
 * @Author wanglonglong
 * @Date 2021/2/10
 * @Version V1.0
 **/
public class MathClass {
    String PATH = "D:\\idea-projects\\lianxi\\PoiAndEaseExcle";
    //计算公式
    @Test
    public void Math() throws Exception {
        FileInputStream fileInputStream = new FileInputStream(PATH+"//poi.xlsx");

        Workbook workbook = new HSSFWorkbook(fileInputStream);

        Sheet sheetAt = workbook.getSheetAt(0);

        Row row = sheetAt.getRow(3);

        Cell cell = row.getCell(0);

        //拿到计算公式
        FormulaEvaluator fFormulaEvaluator = new HSSFFormulaEvaluator((HSSFWorkbook)workbook);
        //输出单元格的内容
        CellType cellType = cell.getCellType();

        fileInputStream.close();
    }
}
