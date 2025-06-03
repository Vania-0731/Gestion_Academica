package com.tecsup.demo.views;

import java.awt.Color;
import java.util.List;
import java.util.Map;

import com.tecsup.demo.domain.entities.Docente;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("docente/ver")
public class DocentePdfView extends AbstractPdfView {

    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
                                    HttpServletRequest request, HttpServletResponse response) throws Exception {

        List<Docente> docentes = (List<Docente>) model.get("docentes");

        PdfPTable tituloTabla = new PdfPTable(1);
        tituloTabla.setSpacingAfter(20);

        PdfPCell titulo = new PdfPCell(new Phrase("Lista de Docentes"));
        titulo.setBackgroundColor(new Color(184, 218, 255));
        titulo.setPadding(8f);
        tituloTabla.addCell(titulo);

        PdfPTable tabla = new PdfPTable(6);  // Cambiado a 6 columnas
        tabla.addCell("ID");
        tabla.addCell("Nombre");
        tabla.addCell("Apellido");
        tabla.addCell("Edad");
        tabla.addCell("Email");
        tabla.addCell("Curso que dicta");  // Nuevo encabezado

        for (Docente docente : docentes) {
            tabla.addCell(String.valueOf(docente.getId()));
            tabla.addCell(docente.getNombre());
            tabla.addCell(docente.getApellido());
            tabla.addCell(String.valueOf(docente.getEdad()));
            tabla.addCell(docente.getEmail());
            tabla.addCell(docente.getCursoQueDicta());  // Nueva celda con el campo
        }

        document.add(tituloTabla);
        document.add(tabla);
    }
}
