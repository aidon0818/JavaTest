/**
 * @author LiuDong
 * @version 1.0.0
 * CreateDate 2020/8/26 17:15
 * Description .
 */
package hutool;

import cn.hutool.core.lang.Console;
import cn.hutool.poi.excel.sax.Excel03SaxReader;
import cn.hutool.poi.excel.sax.handler.RowHandler;

import java.util.List;

/**
 * @version 1.0.0
 * CreateDate 2020/8/26 17:15
 * description
 * @Auther: liudong
 */
public class ExcelTest {
    private static RowHandler createRowHandler() {
        return new RowHandler() {
            @Override
            public void handle(int sheetIndex, long rowIndex, List<Object> rowlist) {
                Console.log("[{}] [{}] {}", sheetIndex, rowIndex, rowlist);
            }
        };
    }

    public static void main(String[] args) {
        Excel03SaxReader reader = new Excel03SaxReader(createRowHandler());
        reader.read("G://aaa.xls", 0);
    }
}