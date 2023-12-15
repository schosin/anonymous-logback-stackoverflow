package de.schosin.spring.security.anonymouslogbackstackoverflow;

import org.slf4j.Marker;
import org.springframework.security.core.context.SecurityContextHolder;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.turbo.TurboFilter;
import ch.qos.logback.core.spi.FilterReply;

public class SecurityContextAccessingTurboFilter extends TurboFilter {

    @Override
    public FilterReply decide(Marker marker, Logger logger, Level level, String format, Object[] params, Throwable t) {
        SecurityContextHolder.getContext(); // this trigger AnonymousAuthenticationFilter#defaultWithAnonymous
        return FilterReply.NEUTRAL;
    }

}
