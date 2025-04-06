package com.intecap.GestorDeParqueo.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalTime;

@Component
public class inteceptorGeneral implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preahandle");
        LocalTime horaAtencion = LocalTime.of(6,0);
        LocalTime horaCierre = LocalTime.of(19,0);
        LocalTime horaActual = LocalTime.now();

        if (horaActual.isAfter(horaAtencion) && horaActual.isBefore(horaCierre))
        {
            return true;
        }
        else {
            if (!response.isCommitted())
            {
                response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                response.getWriter().write("fuera de horario de atencion de GestordeParqueo");
                response.getWriter().flush();
                response.getWriter().close();
            }
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
