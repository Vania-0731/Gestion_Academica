package com.tecsup.demo.views;

import java.util.List;
import java.util.Map;

import com.tecsup.demo.domain.entities.Credito;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("credito/ver.xlsx")
public class CreditoXlsView extends AbstractXlsxView {

    @Override
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {

        response.setHeader("Content-Disposition", "attachment; filename=\"credito_view.xlsx\"");

        List<Credito> creditos = (List<Credito>) model.get("creditos");
        Sheet sheet = workbook.createSheet("Lista de Créditos");

        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue("Listado de Créditos");

        // Estilos
        CellStyle theaderStyle = workbook.createCellStyle();
        theaderStyle.setBorderBottom(BorderStyle.MEDIUM);
        theaderStyle.setBorderTop(BorderStyle.MEDIUM);
        theaderStyle.setBorderRight(BorderStyle.MEDIUM);
        theaderStyle.setBorderLeft(BorderStyle.MEDIUM);
        theaderStyle.setFillForegroundColor(IndexedColors.GOLD.index);
        theaderStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        CellStyle tbodyStyle = workbook.createCellStyle();
        tbodyStyle.setBorderBottom(BorderStyle.THIN);
        tbodyStyle.setBorderTop(BorderStyle.THIN);
        tbodyStyle.setBorderRight(BorderStyle.THIN);
        tbodyStyle.setBorderLeft(BorderStyle.THIN);

        // Cabecera
        Row header = sheet.createRow(4);
        header.createCell(0).setCellValue("ID");
        header.createCell(1).setCellValue("Nombre");
        header.createCell(2).setCellValue("Descripción");
        header.createCell(3).setCellValue("Valor");
        header.createCell(4).setCellValue("Estado");

        for (int i = 0; i <= 4; i++) {
            header.getCell(i).setCellStyle(theaderStyle);
        }

        // Datos
        int rownum = 6;
        for (Credito credito : creditos) {
            Row fila = sheet.createRow(rownum++);

            Cell c0 = fila.createCell(0);
            c0.setCellValue(credito.getId());
            c0.setCellStyle(tbodyStyle);

            Cell c1 = fila.createCell(1);
            c1.setCellValue(credito.getNombre());
            c1.setCellStyle(tbodyStyle);

            Cell c2 = fila.createCell(2);
            c2.setCellValue(credito.getDescripcion() != null ? credito.getDescripcion() : "-");
            c2.setCellStyle(tbodyStyle);

            Cell c3 = fila.createCell(3);
            c3.setCellValue(credito.getValor());
            c3.setCellStyle(tbodyStyle);

            Cell c4 = fila.createCell(4);
            c4.setCellValue(credito.isEstado() ? "Activo" : "Inactivo");
            c4.setCellStyle(tbodyStyle);
        }
    }
}
