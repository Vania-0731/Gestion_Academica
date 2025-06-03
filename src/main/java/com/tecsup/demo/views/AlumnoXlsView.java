package com.tecsup.demo.views;

import com.tecsup.demo.domain.entities.Alumno;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import java.util.List;
import java.util.Map;

@Component("alumno/ver.xlsx")
public class AlumnoXlsView extends AbstractXlsxView {

    @Override
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook,
                                      HttpServletRequest request, HttpServletResponse response) throws Exception {

        response.setHeader("Content-Disposition", "attachment; filename=\"alumno_view.xlsx\"");

        List<Alumno> alumnos = (List<Alumno>) model.get("alumnos");

        Sheet sheet = workbook.createSheet("Lista de Alumnos");

        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue("Lista de alumnos");

        // Estilos
        CellStyle theaderStyle = workbook.createCellStyle();
        theaderStyle.setBorderBottom(BorderStyle.MEDIUM);
        theaderStyle.setBorderTop(BorderStyle.MEDIUM);
        theaderStyle.setBorderRight(BorderStyle.MEDIUM);
        theaderStyle.setBorderLeft(BorderStyle.MEDIUM);
        theaderStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.index);
        theaderStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        CellStyle tbodyStyle = workbook.createCellStyle();
        tbodyStyle.setBorderBottom(BorderStyle.THIN);
        tbodyStyle.setBorderTop(BorderStyle.THIN);
        tbodyStyle.setBorderRight(BorderStyle.THIN);
        tbodyStyle.setBorderLeft(BorderStyle.THIN);

        // Encabezado
        Row header = sheet.createRow(4);
        header.createCell(0).setCellValue("ID");
        header.createCell(1).setCellValue("Nombre");
        header.createCell(2).setCellValue("Apellido");
        header.createCell(3).setCellValue("Edad");
        header.createCell(4).setCellValue("Email");

        for (int i = 0; i <= 4; i++) {
            header.getCell(i).setCellStyle(theaderStyle);
        }

        // Datos
        int rownum = 6;
        for (Alumno alumno : alumnos) {
            Row fila = sheet.createRow(rownum++);

            Cell c0 = fila.createCell(0);
            c0.setCellValue(alumno.getId());
            c0.setCellStyle(tbodyStyle);

            Cell c1 = fila.createCell(1);
            c1.setCellValue(alumno.getNombre());
            c1.setCellStyle(tbodyStyle);

            Cell c2 = fila.createCell(2);
            c2.setCellValue(alumno.getApellido());
            c2.setCellStyle(tbodyStyle);

            Cell c3 = fila.createCell(3);
            c3.setCellValue(alumno.getEdad());
            c3.setCellStyle(tbodyStyle);

            Cell c4 = fila.createCell(4);
            c4.setCellValue(alumno.getEmail());
            c4.setCellStyle(tbodyStyle);
        }
    }
}
