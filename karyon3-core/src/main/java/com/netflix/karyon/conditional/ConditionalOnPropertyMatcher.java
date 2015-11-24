package com.netflix.karyon.conditional;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.netflix.karyon.conditional.annotations.ConditionalOnProperty;
import com.netflix.karyon.spi.PropertySource;

@Singleton
public class ConditionalOnPropertyMatcher implements ConditionalMatcher<ConditionalOnProperty>{
    @Inject
    PropertySource properties;
    
    @Override
    public boolean evaluate(ConditionalOnProperty conditional) {
        return conditional.value().equals(properties.get(conditional.key(), (String)null));
    }
}
