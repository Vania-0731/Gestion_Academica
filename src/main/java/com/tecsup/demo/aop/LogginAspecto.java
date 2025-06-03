package com.tecsup.demo.aop;

import com.tecsup.demo.domain.entities.*;
import com.tecsup.demo.domain.persistence.AuditoriaDao;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Arrays;
import java.util.Calendar;

@Component
@Aspect
public class LogginAspecto {

    private Long tx;

    @Autowired
    private AuditoriaDao auditoriaDao;

    @Around("execution(* com.tecsup.demo.services.*ServiceImpl.*(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result = null;
        Long currTime = System.currentTimeMillis();
        tx = System.currentTimeMillis();
        Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass());
        String metodo = "tx[" + tx + "] - " + joinPoint.getSignature().getName();

        if (joinPoint.getArgs().length > 0)
            logger.info(metodo + "() INPUT:" + Arrays.toString(joinPoint.getArgs()));
        try {
            result = joinPoint.proceed();
        } catch (Throwable e) {
            logger.error(e.getMessage());
        }
        logger.info(metodo + "(): tiempo transcurrido " + (System.currentTimeMillis() - currTime) + " ms.");
        return result;
    }

    @After("execution(* com.tecsup.demo.controllers.*Controller.guardar*(..)) ||" +
            "execution(* com.tecsup.demo.controllers.*Controller.editar*(..)) ||" +
            "execution(* com.tecsup.demo.controllers.*Controller.eliminar*(..))")
    public void auditoria(JoinPoint joinPoint) throws Throwable {
        Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass());
        String metodo = joinPoint.getSignature().getName();
        Integer id = null;
        String tabla = null;

        if (metodo.startsWith("guardar")) {
            Object[] parametros = joinPoint.getArgs();
            Object obj = parametros[0];

            if (obj instanceof Curso) {
                id = ((Curso) obj).getId();
                tabla = "cursos";
            } else if (obj instanceof Alumno) {
                id = ((Alumno) obj).getId();
                tabla = "alumnos";
            } else if (obj instanceof Docente) {
                id = ((Docente) obj).getId();
                tabla = "docentes";
            } else if (obj instanceof Apoderado) {
                id = ((Apoderado) obj).getId();
                tabla = "apoderados";
            } else if (obj instanceof Credito) {
                id = ((Credito) obj).getId();
                tabla = "creditos";
            } else if (obj instanceof Especialidad) {
                id = ((Especialidad) obj).getId();
                tabla = "especialidades";
            }

        } else if (metodo.startsWith("editar") || metodo.startsWith("eliminar")) {
            Object[] parametros = joinPoint.getArgs();
            id = (Integer) parametros[0];
            String clase = joinPoint.getTarget().getClass().getSimpleName().toLowerCase();

            if (clase.contains("curso")) {
                tabla = "cursos";
            } else if (clase.contains("alumno")) {
                tabla = "alumnos";
            } else if (clase.contains("docente")) {
                tabla = "docentes";
            } else if (clase.contains("apoderado")) {
                tabla = "apoderados";
            } else if (clase.contains("credito")) {
                tabla = "creditos";
            } else if (clase.contains("especialidad")) {
                tabla = "especialidades";
            }
        }

        if (tabla != null) {
            String traza = "tx[" + tx + "] - " + metodo;
            logger.info(traza + "(): registrando auditoria...");
            auditoriaDao.save(new Auditoria(tabla, id, Calendar.getInstance().getTime(),
                    "usuario", metodo));
        }
    }

}

