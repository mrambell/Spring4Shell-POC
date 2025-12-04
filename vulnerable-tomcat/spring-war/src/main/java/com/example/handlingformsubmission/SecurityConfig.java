package com.example.handlingformsubmission;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

/**
 * Security configuration to prevent Spring4Shell (CVE-2022-22965) vulnerability
 * by disabling access to ClassLoader and ProtectionDomain via data binding.
 */
@ControllerAdvice
@Configuration
public class SecurityConfig {

    @InitBinder
    public void setDisallowedFields(WebDataBinder dataBinder) {
        // Prevent access to class-level properties that can be exploited
        String[] denyList = new String[]{"class.*", "Class.*", "*.class.*", "*.Class.*"};
        dataBinder.setDisallowedFields(denyList);
    }
}
