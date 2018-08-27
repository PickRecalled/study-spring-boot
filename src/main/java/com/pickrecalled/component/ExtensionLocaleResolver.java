package com.pickrecalled.component;

import org.apache.logging.log4j.util.Strings;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;


public class ExtensionLocaleResolver implements LocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String l = request.getParameter("l");
        if (Strings.isBlank(l)) return Locale.getDefault();
        String[] sl = l.split("_", 2);
        if (null == sl || sl.length <= 0) return Locale.getDefault();
        return new Locale(sl[0], sl[1]);
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
