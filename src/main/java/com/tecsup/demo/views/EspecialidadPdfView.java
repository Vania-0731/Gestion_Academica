package com.tecsup.demo.views;

import java.awt.Color;
import java.util.List;
import java.util.Map;

import com.tecsup.demo.domain.entities.Especialidad;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("especialidad/ver")
public class EspecialidadPdfView extends AbstractPdfView {

    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
                                    HttpServletRequest request, HttpServletResponse response) throws Exception {

        @SuppressWarnings("unchecked")
        List<Especialidad> especialidades = (List<Especialidad>) model.get("especialidades");

        PdfPTable tituloTabla = new PdfPTable(1);
        tituloTabla.setSpacingAfter(20);

        PdfPCell titulo = new PdfPCell(new Phrase("Lista de Especialidades"));
        titulo.setBackgroundColor(new Color(184, 218, 255));
        titulo.setPadding(8f);
        tituloTabla.addCell(titulo);

        PdfPTable tabla = new PdfPTable(4);  // 4 columnas para id, nombre, descripcion, areaAcademica
        tabla.addCell("ID");
        tabla.addCell("Nombre");
        tabla.addCell("Descripción");
        tabla.addCell("Área Académica");

        for (Especialidad especialidad : especialidades) {
            tabla.addCell(String.valueOf(especialidad.getId()));
            tabla.addCell(especialidad.getNombre());
            tabla.addCell(especialidad.getDescripcion());
            tabla.addCell(especialidad.getAreaAcademica());
        }

        document.add(tituloTabla);
        document.add(tabla);
    }
}
