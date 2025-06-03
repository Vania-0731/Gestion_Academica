package com.tecsup.demo.views;

import java.awt.Color;
import java.util.List;
import java.util.Map;

import com.tecsup.demo.domain.entities.Credito;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("credito/ver")
public class CreditoPdfView extends AbstractPdfView {

    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
                                    HttpServletRequest request, HttpServletResponse response) throws Exception {

        List<Credito> creditos = (List<Credito>) model.get("creditos");

        PdfPTable tabla = new PdfPTable(1);
        tabla.setSpacingAfter(20);

        PdfPCell cell = new PdfPCell(new Phrase("Listado de Créditos"));
        cell.setBackgroundColor(new Color(184, 218, 255));
        cell.setPadding(8f);
        tabla.addCell(cell);

        PdfPTable tabla2 = new PdfPTable(5);
        tabla2.addCell("ID");
        tabla2.addCell("Nombre");
        tabla2.addCell("Descripción");
        tabla2.addCell("Valor");
        tabla2.addCell("Estado");

        for (Credito credito : creditos) {
            tabla2.addCell(String.valueOf(credito.getId()));
            tabla2.addCell(credito.getNombre());
            tabla2.addCell(credito.getDescripcion() != null ? credito.getDescripcion() : "-");
            tabla2.addCell(String.valueOf(credito.getValor()));
            tabla2.addCell(credito.isEstado() ? "Activo" : "Inactivo");
        }

        document.add(tabla);
        document.add(tabla2);
    }
}
