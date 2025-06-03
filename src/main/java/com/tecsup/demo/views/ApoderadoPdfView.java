package com.tecsup.demo.views;

import com.tecsup.demo.domain.entities.Apoderado;
import com.lowagie.text.Document;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import java.awt.Color;
import java.util.List;
import java.util.Map;

@Component("apoderado/ver")
public class ApoderadoPdfView extends AbstractPdfView {

    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
                                    HttpServletRequest request, HttpServletResponse response) throws Exception {

        List<Apoderado> apoderados = (List<Apoderado>) model.get("apoderados");

        PdfPTable tabla = new PdfPTable(1);
        tabla.setSpacingAfter(20);

        PdfPCell cell = new PdfPCell(new Phrase("Lista de Apoderados"));
        cell.setBackgroundColor(new Color(184, 218, 255));
        cell.setPadding(8f);
        tabla.addCell(cell);

        PdfPTable tabla2 = new PdfPTable(6); // id, nombre, apellido, dni, telefono, direccion

        tabla2.addCell("ID");
        tabla2.addCell("Nombre");
        tabla2.addCell("Apellido");
        tabla2.addCell("DNI");
        tabla2.addCell("Teléfono");
        tabla2.addCell("Dirección");

        for (Apoderado apoderado : apoderados) {
            tabla2.addCell(String.valueOf(apoderado.getId()));
            tabla2.addCell(apoderado.getNombre());
            tabla2.addCell(apoderado.getApellido());
            tabla2.addCell(apoderado.getDni());
            tabla2.addCell(apoderado.getTelefono());
            tabla2.addCell(apoderado.getDireccion());
        }

        document.add(tabla);
        document.add(tabla2);
    }
}
